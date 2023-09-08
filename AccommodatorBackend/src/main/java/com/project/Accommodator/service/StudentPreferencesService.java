package com.project.Accommodator.service;

import com.project.Accommodator.model.Posting;
import com.project.Accommodator.model.StudentPreferences;

import java.util.List;

public interface StudentPreferencesService {
    public StudentPreferences createStudentPreferences(StudentPreferences studentPreferences);
    public List<Posting> matchStudentPreferences(String university, String foodPreference, String isSmoking, String isDrinking, String livingSpace, String studyEnvironment, String nationality);
}
