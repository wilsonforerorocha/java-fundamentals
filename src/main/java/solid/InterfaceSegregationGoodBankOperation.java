package solid;

public interface InterfaceSegregationGoodBankOperation {
}


interface ATMOperation {
    void makeDeposit();
    void withdrawMoney();
}

interface LoanOperation {
    void approveLoan();
}