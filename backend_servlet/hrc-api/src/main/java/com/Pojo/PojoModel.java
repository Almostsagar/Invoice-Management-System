package com.Pojo;

public class PojoModel {
	public PojoModel(Integer sl_no) {
		super();
		this.sl_no = sl_no;
	}
	public PojoModel() {
		super();
	}
	public PojoModel(String business_code, Integer cust_number, String clear_date, String buisness_year,
			String doc_id, String posting_date, String document_create_date, String document_create_date1,
			String due_in_date, String invoice_currency, String document_type, Integer posting_id, String area_business,
			Double total_open_amount, String baseline_create_date, String cust_payment_terms, Integer invoice_id,
			Integer isOpen, String aging_bucket, Integer is_deleted) {
		super();
		this.business_code = business_code;
		this.cust_number = cust_number;
		this.clear_date = clear_date;
		this.buisness_year = buisness_year;
		this.doc_id = doc_id;
		this.posting_date = posting_date;
		this.document_create_date = document_create_date;
		this.document_create_date1 = document_create_date1;
		this.due_in_date = due_in_date;
		this.invoice_currency = invoice_currency;
		this.document_type = document_type;
		this.posting_id = posting_id;
		this.area_business = area_business;
		this.total_open_amount = total_open_amount;
		this.baseline_create_date = baseline_create_date;
		this.cust_payment_terms = cust_payment_terms;
		this.invoice_id = invoice_id;
		this.isOpen = isOpen;
		this.aging_bucket = aging_bucket;
		this.is_deleted = is_deleted;
	}
	public PojoModel(Integer sl_no, String business_code, Integer cust_number, String clear_date, String buisness_year,
			String doc_id, String posting_date, String document_create_date, String document_create_date1,
			String due_in_date, String invoice_currency, String document_type, Integer posting_id, String area_business,
			Double total_open_amount, String baseline_create_date, String cust_payment_terms, Integer invoice_id,
			Integer isOpen, String aging_bucket, Integer is_deleted) {
		super();
		this.sl_no = sl_no;
		this.business_code = business_code;
		this.cust_number = cust_number;
		this.clear_date = clear_date;
		this.buisness_year = buisness_year;
		this.doc_id = doc_id;
		this.posting_date = posting_date;
		this.document_create_date = document_create_date;
		this.document_create_date1 = document_create_date1;
		this.due_in_date = due_in_date;
		this.invoice_currency = invoice_currency;
		this.document_type = document_type;
		this.posting_id = posting_id;
		this.area_business = area_business;
		this.total_open_amount = total_open_amount;
		this.baseline_create_date = baseline_create_date;
		this.cust_payment_terms = cust_payment_terms;
		this.invoice_id = invoice_id;
		this.isOpen = isOpen;
		this.aging_bucket = aging_bucket;
		this.is_deleted = is_deleted;
	}
	public PojoModel(String business_code, int cust_number, String clear_date, String buisness_year, String doc_id,
			String posting_date, String document_create_date, String due_in_date, String invoice_currency,
			String document_type, int posting_id, double total_open_amount, String baseline_create_date,
			String cust_payment_terms, int invoice_id) {
		super();
		this.business_code = business_code;
		this.cust_number = cust_number;
		this.clear_date = clear_date;
		this.buisness_year = buisness_year;
		this.doc_id = doc_id;
		this.posting_date = posting_date;
		this.document_create_date = document_create_date;
		this.due_in_date = due_in_date;
		this.invoice_currency = invoice_currency;
		this.document_type = document_type;
		this.posting_id = posting_id;
		this.total_open_amount = total_open_amount;
		this.baseline_create_date = baseline_create_date;
		this.cust_payment_terms = cust_payment_terms;
		this.invoice_id = invoice_id;	
		}
	public PojoModel(String invoice_currency, String cust_payment_terms) {
		// TODO Auto-generated constructor stub
		super();
		this.invoice_currency = invoice_currency;
		this.cust_payment_terms = cust_payment_terms;
	}
	private Integer sl_no;	
	private String business_code;
	private Integer cust_number;
	private String clear_date;
	private String buisness_year;
	private String doc_id;
	private String posting_date;
	private String document_create_date;
	private String document_create_date1;
	private String due_in_date;
	private String invoice_currency;
	private String document_type;
	private Integer posting_id;
	private String area_business;
	private Double total_open_amount;
	private String baseline_create_date;
	private String cust_payment_terms;
	private Integer invoice_id;
	private Integer isOpen;
	private String aging_bucket;
	private Integer is_deleted; 
	public Integer getSl_no() {
		return sl_no;
	}
	public void setSl_no(Integer sl_no) {
		this.sl_no = sl_no;
	}
	public String getBusiness_code() {
		return business_code;
	}
	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}
	public Integer getCust_number() {
		return cust_number;
	}
	public void setCust_number(Integer cust_number) {
		this.cust_number = cust_number;
	}
	public String getClear_date() {
		return clear_date;
	}
	public void setClear_date(String clear_date) {
		this.clear_date = clear_date;
	}
	public String getBuisness_year() {
		return buisness_year;
	}
	public void setBuisness_year(String buisness_year) {
		this.buisness_year = buisness_year;
	}
	public String getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	public String getPosting_date() {
		return posting_date;
	}
	public void setPosting_date(String posting_date) {
		this.posting_date = posting_date;
	}
	public String getDocument_create_date() {
		return document_create_date;
	}
	public void setDocument_create_date(String document_create_date) {
		this.document_create_date = document_create_date;
	}
	public String getDocument_create_date1() {
		return document_create_date1;
	}
	public void setDocument_create_date1(String document_create_date1) {
		this.document_create_date1 = document_create_date1;
	}
	public String getDue_in_date() {
		return due_in_date;
	}
	public void setDue_in_date(String due_in_date) {
		this.due_in_date = due_in_date;
	}
	public String getInvoice_currency() {
		return invoice_currency;
	}
	public void setInvoice_currency(String invoice_currency) {
		this.invoice_currency = invoice_currency;
	}
	public String getDocument_type() {
		return document_type;
	}
	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}
	public Integer getPosting_id() {
		return posting_id;
	}
	public void setPosting_id(Integer posting_id) {
		this.posting_id = posting_id;
	}
	public String getArea_business() {
		return area_business;
	}
	public void setArea_business(String area_business) {
		this.area_business = area_business;
	}
	public Double getTotal_open_amount() {
		return total_open_amount;
	}
	public void setTotal_open_amount(Double total_open_amount) {
		this.total_open_amount = total_open_amount;
	}
	public String getBaseline_create_date() {
		return baseline_create_date;
	}
	public void setBaseline_create_date(String baseline_create_date) {
		this.baseline_create_date = baseline_create_date;
	}
	public String getCust_payment_terms() {
		return cust_payment_terms;
	}
	public void setCust_payment_terms(String cust_payment_terms) {
		this.cust_payment_terms = cust_payment_terms;
	}
	public Integer getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(Integer invoice_id) {
		this.invoice_id = invoice_id;
	}
	public Integer getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(Integer isOpen) {
		this.isOpen = isOpen;
	}
	public String getAging_bucket() {
		return aging_bucket;
	}
	public void setAging_bucket(String aging_bucket) {
		this.aging_bucket = aging_bucket;
	}
	public Integer getIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(Integer is_deleted) {
		this.is_deleted = is_deleted;
	}	
}
