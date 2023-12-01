<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta name="description" content="">
        <meta name="author" content="">
        <title>Tạo mới đơn hàng</title>

        <link href="/batdongsan/resources/css/bootstrap.min.css" rel="stylesheet"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <link href="/batdongsan/resources/css/jumbotron-narrow.css" rel="stylesheet">
        <script src="/batdongsan/resources/js/jquery-1.11.3.min.js"></script>
    </head>
    <body>
        <%
            String txt_inv_mobile=(String)request.getAttribute("txt_inv_mobile");
    	    String txt_inv_customer=(String)request.getAttribute("txt_inv_customer");
       	    String vnp_OrderInfo=(String)request.getAttribute("vnp_OrderInfo");
       	    String amount=(String)request.getAttribute("amount");
       	    System.out.println(txt_inv_mobile+" "+txt_inv_customer+" "+vnp_OrderInfo+" "+amount);
        %>
         <div class="container">
           <div class="header clearfix">
                <h3 class="text-muted">VNPAY DEMO</h3>
            </div>
            <h3>Tạo mới đơn hàng</h3>
            <div class="table-responsive">
                <form action="/batdongsan/vnpayajax" id="frmCreateOrder" method="post">
                    <div class="form-group">
                        <label for="amount">Số tiền</label>
                        <input class="form-control" data-val="true" data-val-number="The field Amount must be a number." data-val-required="The Amount field is required." id="amount" max="100000000" min="1" name="amount" type="number" value=<%=amount%> />
						<label for="amount">So dien thoai</label>
                        <input readonly class="txt_inv_mobile form-control" name="txt_inv_mobile" id="txt_inv_mobile" value=<%=txt_inv_mobile%>></input>
						<label for="amount">Ten khach hang</label>
						<input readonly class="txt_inv_customer form-control" name="txt_inv_customer" id="txt_inv_customer" type="text" value='<%=txt_inv_customer%>'></input>
			        	<label for="amount">OrderInfo</label>
						<input readonly class="vnp_OrderInfo form-control" name="vnp_OrderInfo" id="vnp_OrderInfo" value='<%=vnp_OrderInfo%>'></input>
					</div>
                     <h4>Chọn phương thức thanh toán</h4>
                    <div class="form-group">
                       <h5>Cách 1: Tách phương thức tại site của đơn vị kết nối</h5>
                       <input type="radio" id="bankCode" name="bankCode" value="VNBANK">
                       <label for="bankCode">Thanh toán qua thẻ ATM/Tài khoản nội địa</label><br>
                    </div>
                    <div class="form-group">
                        <h5>Chọn ngôn ngữ giao diện thanh toán:</h5>
                         <input type="radio" id="language" Checked="True" name="language" value="vn">
                         <label for="language">Tiếng việt</label><br>
                         <input type="radio" id="language" name="language" value="en">
                         <label for="language">Tiếng anh</label><br>
                    </div>
                    <button type="submit" class="btn btn-default" href>Thanh toán</button>
                </form>
            </div>
            <p>
                &nbsp;
            </p>
            <footer class="footer">
                <p>&copy; VNPAY 2020</p>
            </footer>
        </div>
        <link href="https://pay.vnpay.vn/lib/vnpay/vnpay.css" rel="stylesheet" />
        <script src="https://pay.vnpay.vn/lib/vnpay/vnpay.min.js"></script>
        <script type="text/javascript">
            $("#frmCreateOrder").submit(function () {
                var postData = $("#frmCreateOrder").serialize();
                var submitUrl = $("#frmCreateOrder").attr("action");
                $.ajax({
                    type: "POST",
                    url: submitUrl,
                    data: postData,
                    dataType: 'JSON',
                    success: function (x) {
                        if (x.code === '00') {
                            if (window.vnpay) {
                                vnpay.open({width: 768, height: 600, url: x.data});
                            } else {
                                location.href = x.data;
                            }
                            return false;
                        } else {
                            alert(x.Message);
                        }
                    }
                });
                return false;
            });
        </script>
    </body>
</html>