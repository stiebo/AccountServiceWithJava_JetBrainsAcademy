package account.business;

import account.entities.Payroll;
import account.entities.User;

import java.time.YearMonth;
import java.util.List;

public interface EmployeeService {
    Payroll getPayroll(User user, YearMonth period);
    List<Payroll> getPayrolls(User user);
}
