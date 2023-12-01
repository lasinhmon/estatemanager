package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Contract;
import service.ContractService;
import service.ContractServiceImpl;
import service.EstateService;
import service.EstateServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

@WebServlet(urlPatterns = "/ContractController/*")
public class ContractController extends HttpServlet {
    private static final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    private static final long serialVersionUID=1L;
    private ContractService contractService;
    private EstateService estateService;
    @Override
    public void init() throws ServletException {
        super.init();
        contractService=new ContractServiceImpl();
        estateService=new EstateServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String pathInfo= req.getPathInfo();// local..../employees/giay/nu
        Gson gson=new Gson();
        if(pathInfo==null){
            List<Contract> list=contractService.findAllContract();
            if(list.size()>0){
                String jsonData=gson.toJson(list);
                out.print(jsonData);
            }
            out.close();
        }else if(pathInfo.equals("/newcontract")){
            String date=java.time.LocalDate.now().toString();
            System.out.println(date);
            List<Contract> list=contractService.findNewContract(date);
            if(list.size()>0){
                String jsonData=gson.toJson(list);
                out.print(jsonData);
            }
            out.close();
        } else {
            String[] parts = pathInfo.substring(1).split("/");

            if(parts.length==1){
                if (parts[0].indexOf('-')==-1) {
                    if(pattern.matcher(parts[0]).matches()){
                        int id=parseInt(parts[0]);
                        Contract contract=contractService.findContractById(id);
                        String jsonData=gson.toJson(contract);
                        out.print(jsonData);

                    }else{
                        List<Contract> list=contractService.findContractByName(parts[0]);
                        System.out.println(list.size());
                        if(list.size()>0){
                            String jsonData=gson.toJson(list);
                            out.print(jsonData);
                        }
                    }
                    out.close();
                }else{
                 //   String tam=parts[0];
                    List<Contract> list=contractService.findContractByDate(parts[0]);
                    String jsonData=gson.toJson(list);
                    out.print(jsonData);
                    out.close();
                   // System.out.println("hehe");
                }

            }
            else{
                req.setAttribute("txt_inv_mobile", "0328395414");
                req.setAttribute("txt_inv_customer", parts[0]);
                req.setAttribute("vnp_OrderInfo", parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]);
                req.setAttribute("amount","500000" );

                RequestDispatcher dispatch = req.getRequestDispatcher("/vnpay_pay.jsp");
                dispatch.forward(req, resp);
            }
/////truong, 1 , sold , 2023-02-02
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String pathInfo= req.getPathInfo();
        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();;
        String info=(String)req.getParameter("vnp_OrderInfo");
        String[] parts = info.substring(0).split(",");
        //System.out.println(gia);
        if(pathInfo==null||pathInfo.equals("/")){//if else if sel
            Contract contract=new Contract();
            contract.setUserName(parts[0]);
            contract.setEstateId(Integer.parseInt(parts[1]));
            contract.setUrlContract(parts[2]);
            contract.setStatusContract(parts[3]);
            contract.setDateContract(Date.valueOf(parts[4]));
            contract.setDeadlineContract(Date.valueOf(parts[5]));
            contractService.saveContract(contract);
            estateService.updateStatusEstates(contract.getEstateId());
            //nhay ve 4200
            resp.sendRedirect("http://localhost:4200/");
        }else{
            resp.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json"); //
        String pathInfo= req.getPathInfo();// local..../employees/12
        Gson gson=new Gson();
        if(pathInfo!=null){
            String jsonData = pathInfo.substring(1);
            // int id=parseInt(jsonData);
            Contract contract=gson.fromJson(req.getReader(), Contract.class);
            contractService.updateContractfindById(parseInt(jsonData));
            estateService.updateStatusEstates2(contract.getEstateId());
        }
    }
}
