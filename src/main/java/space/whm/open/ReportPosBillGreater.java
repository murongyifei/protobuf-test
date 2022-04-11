package space.whm.open;

// 属性多的bean
public class ReportPosBillGreater {
    private Integer ognid;
    private String billid;
    private String billno;
    private Integer businesstype;
    private Integer source;
    private String tableno;
    private double totalconsume;
    private double realprice;
    private String pmname;
    private String paytime;
    private Integer billstatus;

    public ReportPosBillGreater(){}
    public ReportPosBillGreater(Integer ognid, String billid, String billno, Integer businesstype, Integer source, String tableno, double totalconsume, double realprice, String pmname, String paytime, Integer billstatus) {
        this.ognid = ognid;
        this.billid = billid;
        this.billno = billno;
        this.businesstype = businesstype;
        this.source = source;
        this.tableno = tableno;
        this.totalconsume = totalconsume;
        this.realprice = realprice;
        this.pmname = pmname;
        this.paytime = paytime;
        this.billstatus = billstatus;
    }

    public Integer getOgnid() {
        return ognid;
    }

    public void setOgnid(Integer ognid) {
        this.ognid = ognid;
    }

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public String getBillno() {
        return billno;
    }

    public void setBillno(String billno) {
        this.billno = billno;
    }

    public Integer getBusinesstype() {
        return businesstype;
    }

    public void setBusinesstype(Integer businesstype) {
        this.businesstype = businesstype;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getTableno() {
        return tableno;
    }

    public void setTableno(String tableno) {
        this.tableno = tableno;
    }

    public double getTotalconsume() {
        return totalconsume;
    }

    public void setTotalconsume(double totalconsume) {
        this.totalconsume = totalconsume;
    }

    public double getRealprice() {
        return realprice;
    }

    public void setRealprice(double realprice) {
        this.realprice = realprice;
    }

    public String getPmname() {
        return pmname;
    }

    public void setPmname(String pmname) {
        this.pmname = pmname;
    }

    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime;
    }

    public Integer getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Integer billstatus) {
        this.billstatus = billstatus;
    }
}
