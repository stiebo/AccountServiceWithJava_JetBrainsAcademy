package account.business;

import account.entities.Payroll;

import java.util.List;

public interface AccountantService {
    void savePayrolls (List<Payroll> payrollList);
    void updateSalary (Payroll payroll);
}
