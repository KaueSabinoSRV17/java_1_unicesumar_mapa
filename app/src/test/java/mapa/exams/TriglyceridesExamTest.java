package mapa.exams;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TriglyceridesExamTest {

    static String VALID_NAME = "Joe Doe";
    static BloodType VALID_BLOOD_TYPE = BloodType.AB_NEGATIVE;

    @Test
    @DisplayName("Should be good if patient is 8 years old and has 74 triglycerides by md/dl")
    void should_be_good_if_patient_is_8_years_old_and_has_74_triglycerides_by_md_dl() {
        Date age = getGivenYearsOldDate(8);
        float validTriglycerideLevel = 74;
        TriglyceridesExam exam = new TriglyceridesExam(VALID_NAME, VALID_BLOOD_TYPE, age, validTriglycerideLevel);
        assertEquals("Good", exam.classifyResult());
    }

    @Test
    @DisplayName("Should be good if patient is 11 years old and has 89 triglycerides by md/dl")
    void should_be_good_if_patient_is_11_years_old_and_has_89_triglycerides_by_md_dl() {
        Date age = getGivenYearsOldDate(11);
        float validTriglycerideLevel = 89;
        TriglyceridesExam exam = new TriglyceridesExam(VALID_NAME, VALID_BLOOD_TYPE, age, validTriglycerideLevel);
        assertEquals("Good", exam.classifyResult());
    }

    @Test
    @DisplayName("Should be good if patient is 21 years old and has 149 triglycerides by md/dl")
    void should_be_good_if_patient_is_21_years_old_and_has_149_triglycerides_by_md_dl() {
        Date age = getGivenYearsOldDate(11);
        float validTriglycerideLevel = 89;
        TriglyceridesExam exam = new TriglyceridesExam(VALID_NAME, VALID_BLOOD_TYPE, age, validTriglycerideLevel);
        assertEquals("Good", exam.classifyResult());
    }

    private Date getGivenYearsOldDate(int desiredAge) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.YEAR, 0 - desiredAge);
        return now.getTime();
    }

}