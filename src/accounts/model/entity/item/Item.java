package accounts.model.entity.item;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

import accounts.model.entity.CompanyDetails;
import accounts.model.entity.LedgerAccount;
import accounts.model.entity.Unit;
import accounts.model.entity.user.User;

@Entity
public class Item {

	@Id
	@TableGenerator(name = "Item_GEN", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", allocationSize = 1)
	@GeneratedValue(strategy= GenerationType.TABLE, generator = "Item_GEN")
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@OneToOne
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	private CompanyDetails company;

	private String itemName;

	@ManyToOne
	private ItemCategory category;

	private String code;

	@Lob
	private byte[] itemLogo;

	@ManyToOne
	private Unit openingStockUnit;

	private String quantity;

	private long valuation;

	@ManyToOne
	private LedgerAccount accountName;

	@ManyToOne
	private LedgerAccount inwardTaxAccount;

	@ManyToOne
	private LedgerAccount outwardTaxAccount;

	private boolean reqBatchNo;

	private Date manufacturingDate;

	private Date expiryDate;

	public CompanyDetails getCompany() {
		return company;
	}

	public void setCompany(CompanyDetails company) {
		this.company = company;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public ItemCategory getCategory() {
		return category;
	}

	public void setCategory(ItemCategory category) {
		this.category = category;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public Unit getOpeningStockUnit() {
		return openingStockUnit;
	}

	public void setOpeningStockUnit(Unit openingStockUnit) {
		this.openingStockUnit = openingStockUnit;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public long getValuation() {
		return valuation;
	}

	public void setValuation(long valuation) {
		this.valuation = valuation;
	}

	public LedgerAccount getAccountName() {
		return accountName;
	}

	public void setAccountName(LedgerAccount accountName) {
		this.accountName = accountName;
	}

	public LedgerAccount getInwardTaxAccount() {
		return inwardTaxAccount;
	}

	public void setInwardTaxAccount(LedgerAccount inwardTaxAccount) {
		this.inwardTaxAccount = inwardTaxAccount;
	}

	public LedgerAccount getOutwardTaxAccount() {
		return outwardTaxAccount;
	}

	public void setOutwardTaxAccount(LedgerAccount outwardTaxAccount) {
		this.outwardTaxAccount = outwardTaxAccount;
	}

	public boolean isReqBatchNo() {
		return reqBatchNo;
	}

	public void setReqBatchNo(boolean reqBatchNo) {
		this.reqBatchNo = reqBatchNo;
	}

	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public byte[] getItemLogo() {
		return itemLogo;
	}

	public void setItemLogo(byte[] itemLogo) {
		this.itemLogo = itemLogo;
	}




}
