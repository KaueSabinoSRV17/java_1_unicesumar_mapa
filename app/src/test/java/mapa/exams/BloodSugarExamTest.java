package mapa.exams;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BloodSugarExamTest {

    static String VALID_NAME = "Joe Doe";
    static BloodType VALID_BLOOD_TYPE = BloodType.AB_NEGATIVE;
    static Date VALID_BIRTH_DATE = Calendar.getInstance().getTime();

    @Test
    @DisplayName("Should be Normoglycemia if Glucose by md/dl is below 100")
    void shouldBeNormoglycemiaIfBelow100mg() {
        BloodSugarExam exam = getValidExamFromGlucoseValue(99);
        assertEquals("Normoglycemia", exam.classifyResult());
    }

    @Test
    @DisplayName("Should be Pre-Diabetes if Glucose by md/dl is above 100 or below 126")
    void shouldBePreDiabetesIfAbove100mg() {
        BloodSugarExam exam = getValidExamFromGlucoseValue(101);
        assertEquals("Pre-Diabetes", exam.classifyResult());
    }

    @Test
    @DisplayName("Should be Diabetes if Glucose by md/dl is above 126")
    void shouldBeNormoglycemiaIfEqualOfAbove126mg() {
        BloodSugarExam exam = getValidExamFromGlucoseValue(126);
        assertEquals("Diabetes", exam.classifyResult());
    }

    @Test
    @DisplayName("Should display correct glucose and result")
    void shouldDisplayCorrectGlucoseAndResult() {
        float expectedGlucose = 101;
        String expectedResult = "Pre-Diabetes";

        BloodSugarExam exam = getValidExamFromGlucoseValue(expectedGlucose);
        exam.classifyResult();

        String expected = "Glucose: " + expectedGlucose + "mg/dl." + "Result: " + expectedResult;
        assertEquals(expected, exam.showResult());
    }

    private BloodSugarExam getValidExamFromGlucoseValue(float glucoseByMgDl) {
        return new BloodSugarExam(VALID_NAME, VALID_BLOOD_TYPE, VALID_BIRTH_DATE, glucoseByMgDl);
    }

}