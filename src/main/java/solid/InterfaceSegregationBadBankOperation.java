package solid;

/**
 * Una clase no debe ser forzada a implementar interfaces que no necesita.
 * Es mejor tener varias interfaces específicas en lugar de una interfaz grande y genérica.
 */
public interface InterfaceSegregationBadBankOperation {
    void makeDeposit();
    void approveLoan(); // Una clase que implemente esta interfaz esta obligada a usar este metodo asi no
    // realice prestamos
    void withdrawMoney();
}
