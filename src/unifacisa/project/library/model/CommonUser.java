package unifacisa.project.library.model;

import unifacisa.project.library.model.enums.UserType;

import java.util.ArrayList;
import java.util.List;

public class CommonUser extends User{
    private List<Loan> activeLoans;

    public CommonUser(Long id, String name, String email, String password) {
        super(id, name, email, password);
        this.activeLoans = new ArrayList<>();
    }

    public List<Loan> getActiveLoans() {
        return activeLoans;
    }

    public void addLoan(Loan loan) {
        this.activeLoans.add(loan);
    }

    public void removedLoan(Loan loan) {
        this.activeLoans.remove(loan);
    }

    @Override
    public UserType getUserType() {
        return UserType.COMMON;
    }

    @Override
    public void showMenu() {
        System.out.println("---- User Menu ----\n1 - Search movie\n2 - Borrow movie\n3 - Return movie\n4 - Contact support\n5 - Exit");
    }


}
