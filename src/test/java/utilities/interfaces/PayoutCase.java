package utilities.interfaces;

public interface PayoutCase {
    int getTestCase();
    void setBetOption();
    void getBetOption();
    void computeTestCase(int[] roundResult);
    void saveTestCase(int[] roundResult);
}
