package account.controller;

import account.controller.dto.GetPayrollResponseDto;
import account.controller.mapper.PayrollMapper;
import account.entities.Payroll;
import account.entities.User;
import account.business.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empl")
public class EmployeeController {
    private final EmployeeService service;
    private final PayrollMapper mapper;

    @Autowired
    public EmployeeController(EmployeeService employeeService, PayrollMapper payrollMapper) {
        this.service = employeeService;
        this.mapper = payrollMapper;
    }

    @GetMapping("/payment")
    public ResponseEntity<?> getPayroll(
            @Valid @RequestParam Optional<YearMonth> period,
            @AuthenticationPrincipal User user) {
        if (period.isPresent()) {
            return ResponseEntity.ok(mapper.toGetPayrollDto(service.getPayroll(user, period.get())));
        } else {
            List<Payroll> foundPayrolls = service.getPayrolls(user);
            return ResponseEntity.ok(foundPayrolls.stream()
                    .map(mapper::toGetPayrollDto)
                    .toArray(GetPayrollResponseDto[]::new));
        }
    }
}
