package pl.sztukakodu.concurrency.week4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DigitsSumTaskTest {
    @Test
    public void shouldCountDigitsSum() {
        DigitsSumTask task = new DigitsSumTask("103908");
        assertEquals(21, task.compute());
    }

    @Test
    public void shouldCountDigitsSumOfVeryLongNumber() {
        String number = "3217893217894893893129080001230932109321093290832890904897189009338943985658973219813";
        DigitsSumTask task = new DigitsSumTask(number);
        assertEquals(391, task.compute());
    }
}
