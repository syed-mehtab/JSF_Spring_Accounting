package accounts.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import accounts.model.entity.user.User;

@Entity
@Table(name="LEDGERACCOUNT")
@NamedQuery(name="LedgerAccount.findAll",query="SELECT led FROM LedgerAccount led WHERE led.company=:comp")
public class LedgerAccount {
	
	@Id
	@TableGenerator(name = "LedgerAccount_GEN", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", allocationSize = 1)
	@GeneratedValue(strategy= GenerationType.TABLE, generator = "LedgerAccount_GEN")
	private long id;

	public long getId() {
		return id;
	}

	
	@OneToOne
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne
	private CompanyDetails company;
	
	private String accountName;
	
	private String accountCode;
	
	@OneToOne
	private LedgerGroup LedgerGroup;
	
	private long openingBalance;
	
	private String internalCode;
	
	//this linked to  LedgerGroup
	private String debit_Credit;

	public CompanyDetails getCompany() {
		return company;
	}

	public void setCompany(CompanyDetails company) {
		this.company = company;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public LedgerGroup getLedgerGroup() {
		return LedgerGroup;
	}

	public void setLedgerGroup(LedgerGroup ledgerGroup) {
		LedgerGroup = ledgerGroup;
	}

	public long getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(long openingBalance) {
		this.openingBalance = openingBalance;
	}

	public String getInternalCode() {
		return internalCode;
	}

	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}

	public String getDebit_Credit() {
		return debit_Credit;
	}

	public void setDebit_Credit(String debit_Credit) {
		this.debit_Credit = debit_Credit;
	}
	

}
