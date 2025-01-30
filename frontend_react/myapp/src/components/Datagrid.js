import React, { useEffect, useState } from "react";
import { DataGrid } from "@mui/x-data-grid";
import axios from "axios";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import DialogContent from "@mui/material/DialogContent";
import DialogContentText from "@mui/material/DialogContentText";
import DialogTitle from "@mui/material/DialogTitle";
import RefreshIcon from "@mui/icons-material/Refresh";
import { Button, TextField } from "@mui/material";
import "./css/datagrid.css";
import { Bar, Pie } from "react-chartjs-2";
import { Chart as ChartJS, registerables } from "chart.js";
import Chart from "chart.js/auto";

function DataGridForHRC() {
  // use states data for datagrid and data crud operations
  const [data, setData] = useState([]);
  const [pageSize, setPageSize] = React.useState(5);
  let [sl_no, setSl_no] = useState("");
  let [business_code, setBusiness_code] = useState("");
  let [cust_number, setCust_number] = useState("");
  let [clear_date, setClear_date] = useState("");
  let [buisness_year, setBuisness_year] = useState("");
  let [doc_id, setDoc_id] = useState("");
  let [posting_date, setPosting_date] = useState("");
  let [document_create_date, setDocument_create_date] = useState("");
  let [document_create_date1, setDocument_create_date1] = useState("");
  let [due_in_date, setDue_in_date] = useState("");
  let [invoice_currency, setInvoice_currency] = useState("");
  let [document_type, setDocument_type] = useState("");
  let [posting_id, setPosting_id] = useState("");
  let [area_business, setArea_business] = useState("");
  let [total_open_amount, setTotal_open_amount] = useState("");
  let [baseline_create_date, setBaseline_create_date] = useState("");
  let [cust_payment_terms, setCust_payment_terms] = useState("");
  let [invoice_id, setInvoice_id] = useState("");
  let [isOpen, setIsOpen] = useState("");
  let [is_deleted, setIs_deleted] = useState("");

  // usestates data for analytics
  let [clear_date1, setClear_date1] = useState("");
  let [clear_date2, setClear_date2] = useState("");
  let [due_in_date1, setDue_in_date1] = useState("");
  let [due_in_date2, setDue_in_date2] = useState("");
  let [baseline_create_date1, setBaseline_create_date1] = useState("");
  let [baseline_create_date2, setBaseline_create_date2] = useState("");

  // usestate for row selected
  let [selectedrows, setSelectedrows] = React.useState();

  // click handlers for dialog components

  // dialog handlers for edit
  const [openEdit, setOpenEdit] = React.useState(false);

  const handleClickEdit = () => {
    setOpenEdit(true);
  };
  const handleCloseEdit = () => {
    setOpenEdit(false);
  };

  // dialog handlers for add
  const [openAdd, setOpenAdd] = React.useState(false);
  const handleClickAdd = () => {
    setOpenAdd(true);
  };

  const handleCloseAdd = () => {
    setOpenAdd(false);
  };

  // dialog handles for delete
  const [openDelete, setOpenDelete] = React.useState(false);

  const handleClickDelete = () => {
    setOpenDelete(true);
  };

  const handleCloseDelete = () => {
    setOpenDelete(false);
  };

  // dialog handlers for adv search
  const [openadvsearch, setopenadvsearch] = React.useState(false);

  const handleopenAdvSearch = () => {
    setopenadvsearch(true);
  };

  const handleCloseAdvSearch = () => {
    setopenadvsearch(false);
  };
  const [openanalyticsdialog, setOpenanalyticsdialog] = React.useState(false);

  const handleClickOpenAnalytics = () => {
    setOpenanalyticsdialog(true);
  };

  const handleCloseAnalytics = () => {
    setOpenanalyticsdialog(false);
  };
  const [open5, setOpen5] = React.useState(false);

  const handleClickOpen5 = () => {
    setOpen5(true);
  };

  const handleClose5 = () => {
    setOpen5(false);
  };

  // some fns for other small functionalities

  const editautofill = (element) => {
    setInvoice_currency(element[0].invoice_currency);
    setCust_payment_terms(element[0].cust_payment_terms);
    console.log(invoice_currency);
    console.log(cust_payment_terms);
    console.log(element[0]);
  };

  const [isDisabled, setDisabled] = useState(true);
  const [isDisabledforEdit, setisDisabledforEdit] = useState(true);
  const deletebtnsel = (ele) => {
    console.log(ele.length);
    if (ele.length !== 0) {
      setDisabled(false);
    }
    if (ele.length === 0) {
      setDisabled(true);
      setisDisabledforEdit(true);
    }
    if (ele.length === 1) {
      setisDisabledforEdit(false);
    }
    if (ele.length === 0) {
    }
    if (ele.length > 1) {
      setisDisabledforEdit(true);
    }
  };

  // handleclicks for crud operations and other operations
  const hrcdata = async () => {
    await axios.get("http://localhost:8080/hrc-api/ServletJson").then((res) => {
      setData(res.data.data);
    });
  };

  const searchHandler = (event) => {
    if (event.keyCode === 13) {
      axios
        .post("http://localhost:8080/hrc-api/DataSearchServlet", {
          cust_number,
        })
        .then((res) => {
          setData(res.data.data);
        });
    }
  };
  const handleAdvsearch = () => {
    // console.log(doc_id);
    // console.log(cust_number);
    // console.log(invoice_id);
    // console.log(buisness_year);
    axios
      .post("http://localhost:8080/hrc-api/DataAdvSearchServlet", {
        doc_id,
        cust_number,
        invoice_id,
        buisness_year,
      })
      .then((res) => {
        setData(res.data.data);
        // console.log(res)
      });
    handleCloseAdvSearch();
  };

  const handleDelete = () => {
    selectedrows.forEach((element) => {
      sl_no = element.sl_no;
      axios.post("http://localhost:8080/hrc-api/DataDeleteServlet", { sl_no });
      // .then((res) => {
      //     console.log(res)
      // })
    });
    handleCloseDelete();
  };

  const handleAdd = () => {
    axios.post("http://localhost:8080/hrc-api/ServletAdd", {
      business_code,
      cust_number,
      clear_date,
      buisness_year,
      doc_id,
      posting_date,
      document_create_date,
      due_in_date,
      invoice_currency,
      document_type,
      posting_id,
      total_open_amount,
      baseline_create_date,
      cust_payment_terms,
      invoice_id,
    });
    // .then((res) => {
    //     console.log(res)
    // })
    handleCloseAdd();
  };

  const handleEdit = () => {
    selectedrows.forEach((element) => {
      sl_no = element.sl_no;
      axios.post("http://localhost:8080/hrc-api/DataUpdateServlet", {
        sl_no,
        invoice_currency,
        cust_payment_terms,
      });
      // .then((res) => {
      //     console.log(res)
      // })
    });
    handleCloseEdit();
  };

  // Prediction start
  let [aging_bucket, setAging_bucket] = useState("");

  const handlePredict = () => {
    let name_customer, converted_usd;
    selectedrows.forEach((element) => {
      business_code = element.business_code;
      cust_number = element.cust_number;
      name_customer = "highradius";
      clear_date = element.clear_date;
      buisness_year = element.buisness_year;
      doc_id = element.doc_id;
      posting_date = element.posting_date;
      due_in_date = element.due_in_date;
      baseline_create_date = element.baseline_create_date;
      cust_payment_terms = element.cust_payment_terms;
      if (element.invoice_currency !== "USD") {
        element.total_open_amount = element.total_open_amount * 0.7;
        converted_usd = element.total_open_amount;
      } else {
        converted_usd = element.total_open_amount;
      }

      axios
        .post("http://127.0.0.1:5000/", {
          business_code,
          cust_number,
          name_customer,
          clear_date,
          buisness_year,
          doc_id,
          posting_date,
          due_in_date,
          baseline_create_date,
          cust_payment_terms,
          converted_usd,
        })
        .then((res) => {
          setAging_bucket(res.data[0].aging_bucket);
        });
    });
  };

  // prediction end

  // const [predictedRow, setpredictedRow ] = useState('')
  // const predictrowdatafill = (ele) => {
  //     console.log('predict');
  //     console.log(ele[0].aging_bucket);
  //     console.log(aging_bucket);
  // }

  // analytics part start

  // bar chart
  let [toaFinal1, settoaFinal1] = useState();
  let [toaFinal2, settoaFinal2] = useState();
  let [toaFinal3, settoaFinal3] = useState();
  let [toaFinal4, settoaFinal4] = useState();
  let [toaFinal5, settoaFinal5] = useState();
  let [toaFinal6, settoaFinal6] = useState();

  let [nocFinal1, setnocFinal1] = useState();
  let [nocFinal2, setnocFinal2] = useState();
  let [nocFinal3, setnocFinal3] = useState();
  let [nocFinal4, setnocFinal4] = useState();
  let [nocFinal5, setnocFinal5] = useState();
  let [nocFinal6, setnocFinal6] = useState();

  //  pie chart
  let [currusd, setcurrusd] = useState();
  let [currcad, setcurrcad] = useState();

  // click handle for analytics
  const handleAnalytics = () => {
    axios
      .post("http://localhost:8080/hrc-api/AnalyticsViewServlet", {
        clear_date1,
        clear_date2,
        due_in_date1,
        due_in_date2,
        baseline_create_date1,
        baseline_create_date2,
        invoice_currency,
      })
      .then((res) => {
        // toa - sum of total_open_amount
        // noc - no of customer for business year

        // variables for Bar
        let toa1 = 0,
          toa2 = 0,
          toa3 = 0,
          toa4 = 0,
          toa5 = 0,
          toa6 = 0;
        let noc1 = 0,
          noc2 = 0,
          noc3 = 0,
          noc4 = 0,
          noc5 = 0,
          noc6 = 0;

        // variables for Pie
        let usd1 = 0;
        let cad1 = 0;

        // looping through response data to change the states of toa and noc
        for (let index = 0; index < res.data.data.length; index++) {
          if (res.data.data[index].business_code === "U001") {
            toa1 = toa1 + res.data.data[index].total_open_amount;
            noc1 = noc1 + 1;
          }
          if (res.data.data[index].business_code === "CA02") {
            toa2 = toa2 + res.data.data[index].total_open_amount;
            noc2 = noc2 + 1;
          }
          if (res.data.data[index].business_code === "U013") {
            toa3 = toa3 + res.data.data[index].total_open_amount;
            noc3 = noc3 + 1;
          }
          if (res.data.data[index].business_code === "U002") {
            toa4 = toa4 + res.data.data[index].total_open_amount;
            noc4 = noc4 + 1;
          }
          if (res.data.data[index].business_code === "U005") {
            toa5 = toa5 + res.data.data[index].total_open_amount;
            noc5 = noc5 + 1;
          }
          if (res.data.data[index].business_code === "U007") {
            toa6 = toa6 + res.data.data[index].total_open_amount;
            noc6 = noc6 + 1;
          }
        }
        // looping through original data to get the no of cust with usd and cad payments
        for (let index = 0; index < data.length; index++) {
          if (data[index].invoice_currency === "USD") {
            usd1 = usd1 + 1;
          }
          if (data[index].invoice_currency === "CAD") {
            cad1 = cad1 + 1;
          }
        }
        // setting bar chart variable values to usestates
        settoaFinal1(toa1);
        settoaFinal2(toa2);
        settoaFinal3(toa3);
        settoaFinal4(toa4);
        settoaFinal5(toa5);
        settoaFinal6(toa6);
        setnocFinal1(noc1);
        setnocFinal2(noc2);
        setnocFinal3(noc3);
        setnocFinal4(noc4);
        setnocFinal5(noc5);
        setnocFinal6(noc6);

        // setting pie chart variable values to usestates
        setcurrusd(usd1);
        setcurrcad(cad1);
      });

    handleCloseAnalytics();
  };
  // setting options for bar chart
  const options = {
    maintainAspectRatio: false,
    legend: {
      labels: {
        fontSize: 23,
      },
      title: {
        display: true,
        text: "Chart.js Bar Chart",
      },
    },
  };
  // side lables of bar
  const labels = [
    "Business 1",
    "Buiseness 2",
    "Buiseness 3",
    "Business 4",
    "Buiseness 5",
    "Buiseness 6",
  ];

  // bar chart data
  let DataforBar = {
    labels,
    datasets: [
      {
        label: "No of Customers",
        data: [
          nocFinal1,
          nocFinal2,
          nocFinal3,
          nocFinal4,
          nocFinal5,
          nocFinal6,
        ],
        backgroundColor: "rgba(255, 99, 132, 0.2)",

        borderColor: "rgba(255, 99, 132, 1)",
        borderWidth: 1,
      },
      {
        label: "Total Open Amount",
        data: [
          toaFinal1,
          toaFinal2,
          toaFinal3,
          toaFinal4,
          toaFinal5,
          toaFinal6,
        ],
        backgroundColor: "rgba(54, 162, 235, 0.2)",
        borderColor: "rgba(54, 162, 235, 1)",
        borderWidth: 1,
      },
    ],
  };

  // pie chart data
  let DataForPie = {
    labels: ["USD", "CAD"],
    datasets: [
      {
        data: [currusd, currcad],
        backgroundColor: ["rgba(54, 162, 235, 1)", "rgba(255, 99, 132, 0.2)"],
        borderColor: "rgba(255, 99, 132, 1)",
        borderWidth: 1,
      },
    ],
  };

  // analytics end

  // useeffect for datagrid

  function dateFormatter(params) {
    var dateAsString = new Date(params);
    var year = dateAsString.getFullYear();

    return year;
  }

  useEffect(() => {
    hrcdata();
  }, []);

  const columns = [
    { field: "sl_no", headerName: "Sl no", width: 60 },
    { field: "business_code", headerName: "Business Code", width: 120 },
    { field: "cust_number", headerName: "Customer Number", width: 120 },
    { field: "clear_date", headerName: "Clear Date", width: 100 },
    { field: "buisness_year", headerName: "Bussiness Year", width: 120 },
    { field: "doc_id", headerName: "Document Id", width: 110 },
    { field: "posting_date", headerName: "Posting Date", width: 100 },
    {
      field: "document_create_date",
      headerName: "Document Create Date",
      width: 170,
    },
    { field: "due_in_date", headerName: "Due Date", width: 100 },
    { field: "invoice_currency", headerName: "Invoice Currency", width: 122 },
    { field: "document_type", headerName: "Document Type", width: 122 },
    { field: "posting_id", headerName: "Posting Id", width: 90 },
    { field: "total_open_amount", headerName: "total_open_amount", width: 150 },
    {
      field: "baseline_create_date",
      headerName: "baseline_create_date",
      width: 150,
    },
    {
      field: "cust_payment_terms",
      headerName: "Customer Payment Terms",
      width: 150,
    },
    { field: "invoice_id", headerName: "invoice_id", width: 110 },
    { field: "aging_bucket", headerName: "Aging Bucket", width: 110 },
  ];

  const rows = data.map((row) => ({
    sl_no: row.sl_no,
    business_code: row.business_code,
    cust_number: row.cust_number,
    clear_date: row.clear_date,
    buisness_year: dateFormatter(row.buisness_year),
    doc_id: row.doc_id,
    posting_date: row.posting_date,
    document_create_date: row.document_create_date,
    document_create_date1: row.document_create_date1,
    due_in_date: row.due_in_date,
    invoice_currency: row.invoice_currency,
    document_type: row.document_type,
    posting_id: row.posting_id,
    area_business: row.area_business,
    total_open_amount: row.total_open_amount,
    baseline_create_date: row.baseline_create_date,
    invoice_id: row.invoice_id,
    isOpen: row.isOpen,
    aging_bucket: aging_bucket,
    is_deleted: row.is_deleted,
    cust_payment_terms: row.cust_payment_terms,
  }));

  return (
    <div>
      <div className="all">
        <div className="buttons buttonsrescss topbuttons">
          <Button
            variant="outlined"
            className="buttonStyle1"
            onClick={handlePredict}
          >
            {" "}
            PREDICT{" "}
          </Button>{" "}
          <Button
            variant="outlined"
            className="buttonStyle2"
            onClick={handleClickOpenAnalytics}
          >
            {" "}
            ANALYTICS VIEW{" "}
          </Button>
          <Dialog
            open={openanalyticsdialog}
            onClose={handleCloseAnalytics}
            maxWidth="lg"
          >
            <DialogTitle className="dialog1"> Analytics View </DialogTitle>{" "}
            <DialogContent className="dialog2">
              <div className="analyticscss">
                <div className="analyticscss-div1">
                  <label style={{ color: "white" }}> Clear Date </label>{" "}
                  <TextField
                    onChange={(e) => setClear_date1(e.target.value)}
                    className="editin textfieldwid"
                    variant="filled"
                    id="fullWidth"
                    type={"date"}
                  />{" "}
                  &nbsp; &nbsp;{" "}
                  <TextField
                    onChange={(e) => setClear_date2(e.target.value)}
                    className="editin textfieldwid"
                    variant="filled"
                    id="fullWidth"
                    type={"date"}
                  />{" "}
                </div>
                <div className="analyticscss-div2">
                  <label style={{ color: "white" }}> Due Date </label>{" "}
                  <TextField
                    onChange={(e) => setDue_in_date1(e.target.value)}
                    className="editin textfieldwid"
                    variant="filled"
                    id="fullWidth"
                    type={"date"}
                  />{" "}
                  &nbsp; &nbsp;{" "}
                  <TextField
                    onChange={(e) => setDue_in_date2(e.target.value)}
                    className="editin textfieldwid"
                    variant="filled"
                    id="fullWidth"
                    type={"date"}
                  />{" "}
                </div>
                <div className="analyticscss-div3">
                  <label style={{ color: "white" }}>
                    {" "}
                    Baseline Create Date{" "}
                  </label>{" "}
                  <TextField
                    onChange={(e) => setBaseline_create_date1(e.target.value)}
                    className="editin textfieldwid"
                    variant="filled"
                    id="fullWidth"
                    type={"date"}
                  />{" "}
                  &nbsp; &nbsp;{" "}
                  <TextField
                    onChange={(e) => setBaseline_create_date2(e.target.value)}
                    className="editin textfieldwid"
                    variant="filled"
                    id="fullWidth"
                    type={"date"}
                  />{" "}
                </div>
                <div className="analyticscss-divlast">
                  <label style={{ color: "white" }}> Invoice Currency </label>{" "}
                  <TextField
                    onChange={(e) => setInvoice_currency(e.target.value)}
                    className="editin"
                    variant="filled"
                    label="Invoice Currency"
                    id="fullWidth"
                  />
                </div>{" "}
              </div>{" "}
            </DialogContent>{" "}
            <DialogActions className="dialog3">
              <Button
                variant="outlined"
                className="dialogbtn1"
                onClick={function () {
                  handleAnalytics();
                  handleClickOpen5();
                }}
              >
                {" "}
                SUBMIT{" "}
              </Button>{" "}
              <Button
                variant="outlined"
                className="dialogbtn1"
                onClick={handleCloseAnalytics}
              >
                {" "}
                Cancel{" "}
              </Button>{" "}
            </DialogActions>{" "}
          </Dialog>
          <Dialog
            open={open5}
            onClose={handleClose5}
            fullWidth={true}
            maxWidth={"lg"}
          >
            <DialogTitle> Analytics View </DialogTitle>{" "}
            <DialogContent>
              <div
                style={{ height: "490px", width: "650px", margin: "0 auto" }}
              >
                <Bar options={options} data={DataforBar} />{" "}
              </div>{" "}
              <div
                style={{ height: "400px", width: "400px", margin: "0 auto" }}
              >
                <Pie
                  options={{
                    responsive: true,
                    plugins: {
                      legend: {
                        display: true,
                        position: "top",
                      },
                      title: {
                        display: true,
                        text: "Chart.js Pie Chart",
                      },
                    },
                  }}
                  data={DataForPie}
                />
              </div>{" "}
            </DialogContent>{" "}
          </Dialog>
          <Button
            variant="outlined"
            className="buttonStyle3"
            onClick={handleopenAdvSearch}
          >
            
            ADVANCE SEARCH
          </Button>{" "}
          <Dialog
            open={openadvsearch}
            onClose={handleCloseAdvSearch}
            maxWidth="xl"
          >
            <DialogTitle className="dialog1"> Advance Search </DialogTitle>{" "}
            <DialogContent className="dialog2">
              <div className="advgrid">
                <div>
                  <TextField
                    onChange={(e) => setDoc_id(e.target.value)}
                    className="editin"
                    variant="filled"
                    label="Document ID"
                    id="fullWidth"
                  />
                  &nbsp; &nbsp; &nbsp;{" "}
                  <TextField
                    onChange={(e) => setInvoice_id(e.target.value)}
                    className="editin"
                    variant="filled"
                    label="Invoice Id"
                    id="fullWidth"
                  />
                </div>{" "}
                <div>
                  <TextField
                    onChange={(e) => setCust_number(e.target.value)}
                    className="editin"
                    variant="filled"
                    label="Customer Number"
                    id="fullWidth"
                  />
                  &nbsp; &nbsp; &nbsp;{" "}
                  <TextField
                    onChange={(e) => setBuisness_year(e.target.value)}
                    className="editin"
                    variant="filled"
                    label="Business Year"
                    id="fullWidth"
                  />
                </div>{" "}
              </div>{" "}
            </DialogContent>{" "}
            <DialogActions className="dialog3">
              <Button
                variant="outlined"
                className="dialogbtn1"
                onClick={handleAdvsearch}
              >
                {" "}
                SEARCH{" "}
              </Button>{" "}
              <Button
                variant="outlined"
                className="dialogbtn1"
                onClick={handleCloseAdvSearch}
              >
                {" "}
                Cancel{" "}
              </Button>{" "}
            </DialogActions>{" "}
          </Dialog>{" "}
        </div>{" "}
        <div className="buttonsrescss">
          <RefreshIcon
            variant="outlined"
            className="refreshicon"
            onClick={hrcdata}
          />{" "}
        </div>{" "}
        <div className="inputCid buttonsrescss">
          <TextField
            onChange={(e) => setCust_number(e.target.value)}
            onKeyDown={(e) => searchHandler(e)}
            className="custin"
            variant="filled"
            label="Search Custumer Id"
            id="fullWidth"
            inputProps={{ inputMode: "numeric", pattern: "[0-9]*" }}
          />{" "}
        </div>{" "}
        <div className="buttons buttonsrescss bottombuttons">
          <Button
            variant="outlined"
            className="buttonStyle4"
            onClick={handleClickAdd}
          >
            {" "}
            ADD{" "}
          </Button>{" "}
          <Dialog open={openAdd} onClose={handleCloseAdd} maxWidth="xl">
            <DialogTitle className="dialog1"> Add </DialogTitle>{" "}
            <DialogContent className="dialog2">
              <div className="addgrid">
                <div className="addgriditem">
                  <TextField
                    onChange={(e) => setBusiness_code(e.target.value)}
                    className="editin textfieldwid"
                    variant="filled"
                    label="Business code"
                  />
                  &nbsp; &nbsp; &nbsp;{" "}
                  <TextField
                    onChange={(e) => setCust_number(e.target.value)}
                    className="editin textfieldwid"
                    variant="filled"
                    label="Customer Number"
                  />
                  &nbsp; &nbsp; &nbsp;{" "}
                  <TextField
                    onChange={(e) => setClear_date(e.target.value)}
                    className="editin textfieldwid"
                    variant="filled"
                    label="Clear Date"
                    type={"date"}
                  />{" "}
                  &nbsp; &nbsp; &nbsp;{" "}
                  <TextField
                    onChange={(e) => setBuisness_year(e.target.value)}
                    className="editin textfieldwid"
                    variant="filled"
                    label="Business Year"
                  />
                </div>{" "}
                <div className="addgriditem">
                  <TextField
                    onChange={(e) => setDoc_id(e.target.value)}
                    className="editin textfieldwid"
                    variant="filled"
                    label="Document id"
                  />
                  &nbsp; &nbsp; &nbsp;{" "}
                  <TextField
                    onChange={(e) => setPosting_date(e.target.value)}
                    className="editin textfieldwid"
                    variant="filled"
                    label="Posting date"
                    type={"date"}
                  />{" "}
                  &nbsp; &nbsp; &nbsp;{" "}
                  <TextField
                    onChange={(e) => setDocument_create_date(e.target.value)}
                    className="editin textfieldwid"
                    variant="filled"
                    label="Document Create Date"
                    type={"date"}
                  />{" "}
                  &nbsp; &nbsp; &nbsp;{" "}
                  <TextField
                    onChange={(e) => setDue_in_date(e.target.value)}
                    className="editin textfieldwid"
                    variant="filled"
                    label="Due Date"
                    type={"date"}
                  />{" "}
                </div>{" "}
                <div className="addgriditem">
                  <TextField
                    onChange={(e) => setInvoice_currency(e.target.value)}
                    className="editin textfieldwid"
                    variant="filled"
                    label="Invoice currency"
                  />
                  &nbsp; &nbsp; &nbsp;{" "}
                  <TextField
                    onChange={(e) => setDocument_type(e.target.value)}
                    className="editin textfieldwid"
                    variant="filled"
                    label="Document type"
                  />
                  &nbsp; &nbsp; &nbsp;{" "}
                  <TextField
                    onChange={(e) => setPosting_id(e.target.value)}
                    className="editin textfieldwid"
                    variant="filled"
                    label="Posting Id"
                  />
                  &nbsp; &nbsp; &nbsp;{" "}
                  <TextField
                    onChange={(e) => setTotal_open_amount(e.target.value)}
                    className="editin textfieldwid"
                    variant="filled"
                    label="Total open amount"
                  />
                </div>{" "}
                <div className="addgriditem">
                  <TextField
                    onChange={(e) => setBaseline_create_date(e.target.value)}
                    className="editin textfieldwid"
                    variant="filled"
                    label="Baseline create date"
                    type={"date"}
                    placeholder=""
                  />
                  &nbsp; &nbsp; &nbsp;{" "}
                  <TextField
                    onChange={(e) => setCust_payment_terms(e.target.value)}
                    className="editin textfieldwid"
                    variant="filled"
                    label="Customer Payment Terms"
                  />
                  &nbsp; &nbsp; &nbsp;{" "}
                  <TextField
                    onChange={(e) => setInvoice_id(e.target.value)}
                    className="editin textfieldwid"
                    variant="filled"
                    label="Invoice Id"
                  />
                </div>
              </div>{" "}
            </DialogContent>{" "}
            <DialogActions className="dialog3">
              <Button
                variant="outlined"
                className="dialogbtn2"
                onClick={handleAdd}
              >
                {" "}
                Add{" "}
              </Button>{" "}
              <Button
                variant="outlined"
                className="dialogbtn1"
                onClick={handleCloseAdd}
              >
                {" "}
                Cancel{" "}
              </Button>{" "}
            </DialogActions>{" "}
          </Dialog>{" "}
          <Button
            variant="outlined"
            className="buttonStyle5"
            onClick={handleClickEdit}
            disabled={isDisabledforEdit}
          >
            {" "}
            EDIT{" "}
          </Button>{" "}
          <Dialog open={openEdit} onClose={handleCloseEdit}>
            <DialogTitle className="dialog1"> Edit </DialogTitle>{" "}
            <DialogContent className="dialog2">
              <TextField
                onChange={(e) => setInvoice_currency(e.target.value)}
                value={invoice_currency}
                className="editin"
                variant="filled"
                label="Invoice Currency"
              />
              &nbsp; &nbsp; &nbsp;{" "}
              <TextField
                onChange={(e) => setCust_payment_terms(e.target.value)}
                value={cust_payment_terms}
                className="editin"
                variant="filled"
                label="Customer Payment Terms"
              />
            </DialogContent>{" "}
            <DialogActions className="dialog3">
              <Button
                variant="outlined"
                className="dialogbtn2"
                onClick={handleEdit}
                autoFocus
              >
                {" "}
                Edit{" "}
              </Button>{" "}
              <Button
                variant="outlined"
                className="dialogbtn1"
                onClick={handleCloseEdit}
              >
                {" "}
                Cancel{" "}
              </Button>{" "}
            </DialogActions>{" "}
          </Dialog>{" "}
          <Button
            variant="outlined"
            className="buttonStyle6"
            onClick={handleClickDelete}
            disabled={isDisabled}
          >
            {" "}
            DELETE{" "}
          </Button>{" "}
          <Dialog
            className="dialogstyle"
            open={openDelete}
            onClose={handleCloseDelete}
          >
            <DialogTitle className="dialog1"> {"Delete Records?"} </DialogTitle>{" "}
            <DialogContent className="dialog2">
              <DialogContentText className="dialog2title">
                Are you sure you want to delete these record[s] ?
              </DialogContentText>{" "}
            </DialogContent>{" "}
            <DialogActions className="dialog3">
              <Button
                variant="outlined"
                className="dialogbtn1"
                onClick={handleCloseDelete}
              >
                {" "}
                Cancel{" "}
              </Button>{" "}
              <Button
                variant="outlined"
                className="dialogbtn2"
                onClick={handleDelete}
              >
                {" "}
                Delete{" "}
              </Button>{" "}
            </DialogActions>{" "}
          </Dialog>{" "}
        </div>{" "}
      </div>
      {/* // Datagrid code starts */}{" "}
      <div style={{ height: 320, width: "100%", backgroundColor: "#283D4A" }}>
        <DataGrid
          rows={rows}
          columns={columns}
          getRowId={(row) => row.sl_no}
          onSelectionModelChange={(row) => {
            const selectedID = new Set(row);
            const selectedRows = rows.filter((row) =>
              selectedID.has(row.sl_no)
            );
            setSelectedrows(selectedRows);
            deletebtnsel(selectedRows);
            editautofill(selectedRows);
          }}
          checkboxSelection
          disableSelectionOnClick
          rowHeight={30}
          headerHeight={100}
          style={{ color: "white", border: "0" }}
          pageSize={pageSize}
          onPageSizeChange={(newPageSize) => setPageSize(newPageSize)}
          rowsPerPageOptions={[5, 10, 20]}
          pagination
        />
      </div>{" "}
      {/* // Datagrid code ends */}{" "}
    </div>
  );
}

export default DataGridForHRC;
