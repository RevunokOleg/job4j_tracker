package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        double sum = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            int subjectsCount = pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            double scoreByPupil = sum / subjectsCount;
            labels.add(new Label(pupil.name(), scoreByPupil));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> scoreBySubject = new LinkedHashMap<>();
        int pupilsCount = pupils.size();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scoreBySubject.put(subject.name(), scoreBySubject.getOrDefault(subject.name(), 0)
                        + subject.score());
            }
        }
        for (String key : scoreBySubject.keySet()) {
            Integer value = scoreBySubject.get(key);
            labels.add(new Label(key, (double) value / pupilsCount));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        double sum = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            labels.add(new Label(pupil.name(), sum));
            sum = 0;
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> scoreBySubject = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scoreBySubject.put(subject.name(), scoreBySubject.getOrDefault(subject.name(), 0)
                        + subject.score());
            }
        }
        for (String key : scoreBySubject.keySet()) {
            Integer value = scoreBySubject.get(key);
            labels.add(new Label(key, (double) value));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}