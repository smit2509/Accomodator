import React from 'react';
import axios from 'axios';

class AddPost extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            type: '',
            image: [],
            description: '',
            Rent: '',
            address: '',
            pincode: '',
            category: '',
            email: '',
            error: '',
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    validateImages(files) {
        const validExtensions = ['.jpg', '.jpeg', '.png'];
        for (let i = 0; i < files.length; i++) {
            const extension = files[i].name.split('.').pop().toLowerCase();
            if (!validExtensions.includes('.' + extension)) {
                return false;
            }
        }
        return true;
    }

    handleChange(event) {
        const {name, value, files} = event.target;
        if (name === 'image') {
            if (!this.validateImages(files)) {
                this.setState({error: 'Invalid file type. Please select images with .jpg, .jpeg, or .png extensions.'});
            } else {
                this.setState({image: files, error: ''});
            }
        } else {
            this.setState({[name]: value});
        }
    }

    handleSubmit(event) {
        const user = JSON.parse(localStorage.getItem('user'));
        const ownerId = user.studentId;
        event.preventDefault();
        const {type, image, description, rent, address, pincode, category, email} = this.state;

        // Get the current date
        const currentDate = new Date();
        const formattedDate = `${currentDate.getFullYear()}-${currentDate.getMonth() + 1}-${currentDate.getDate()}`;
        const postingData = {
            rent: rent,
            address: address,
            description: description,
            date: formattedDate,
            category: category,
            image: image.name,
            ownerId: ownerId,
            type: type,
            pincode: pincode,
            email: email,
          };

                    axios.post('http://localhost:8080/posting/create', postingData).then((response) => {
                            if (response.status === 200) {
                                window.location.href = '/Features';
                            } else {
                                console.error('Post creation failed:', response.data.message);
                            }
                        })
                        .catch((error) => {
                            console.error('An error occurred:', error);
                        });
                    }
    render() {
        const { error } = this.state;
        return (
            <div className="auth-wrapper">
                <div className="form-container">
                    <div className="auth-inner">
                        <h2 className="text-center mb-3">
                            Add a Post
                        </h2>
                        <form onSubmit={this.handleSubmit}>
                            <div className="form-group">
                                <label htmlFor="type">
                                    Type
                                </label>
                                <select className="form-control" id="type" name="type" onChange={this.handleChange} required>
                                    <option value="">Select Type</option>
                                    <option value="apartment">Apartment</option>
                                    <option value="condo">Condo</option>
                                    <option value="townhouse">Townhouse</option>
                                </select>
                            </div>
                            <div className="form-group">
                                <label htmlFor="image">
                                    Images
                                </label>
                                <input
                                    type="file"
                                    className="form-control-file"
                                    id="image"
                                    name="image"
                                    onChange={this.handleChange}
                                    multiple
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="description">
                                    Description
                                </label>
                                <textarea
                                    className="form-control"
                                    id="description"
                                    name="description"
                                    onChange={this.handleChange}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="rent">
                                    Rent
                                </label>
                                <input
                                    type="number"
                                    className="form-control"
                                    id="rent"
                                    name="rent"
                                    onChange={this.handleChange}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="address">
                                    Address
                                </label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="address"
                                    name="address"
                                    onChange={this.handleChange}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="pincode">
                                    Pincode
                                </label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="pincode"
                                    name="pincode"
                                    maxLength="6"
                                    onChange={this.handleChange}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="category">
                                    Category
                                </label>
                                <select className="form-control" id="category" name="category" onChange={this.handleChange} required>
                                    <option value="">Select Category</option>
                                    <option value="lease">Lease</option>
                                    <option value="roommate">Roommate</option>
                                </select>
                            </div>
                            <div className="form-group">
                                <label htmlFor="email">
                                    Email to be contacted
                                </label>
                                <input
                                    type="email"
                                    className="form-control"
                                    id="email"
                                    name="email"
                                    onChange={this.handleChange}
                                    required
                                />
                            </div>
                            {error && <div className="alert alert-danger">{error}</div>}
                            <div className="form-group mt-3">
                                <button type="submit" className="btn btn-primary btn-block">
                                    Submit
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        );
    }

}
export default AddPost;
