<%-- 
    Document   : account
    Created on : Oct 14, 2012, 4:24:12 PM
    Author     : Utkarsh
--%>

<%@include file="header.jsp" %>
  <!-- BEFORE CONTENT -->
        <div id="outerbeforecontent">
        	<div class="container">
                <section id="beforecontent" class="twelve columns">
                    <h1 class="pagetitle">My Account</h1>
                    <div class="clear"></div>
                </section>
            </div>
        </div>
        <!-- END BEFORE CONTENT -->
        
        <!-- MAIN CONTENT -->
        <div id="outermain">
        	<div class="container">
			<section id="maincontent" class="twelve columns">
				
                <p>Hello, <strong>admin</strong>. From your account dashboard you can view your recent orders, manage your shipping and billing addresses and 
                <a href="#">change your password</a>.</p>
                <h3>Recent Orders</h3>
                <table class="my_account_orders">
                    <thead>
                        <tr>
                            <th class="no-order"><span class="nobr">#</span></th>
                            <th><span class="nobr">Date</span></th>
                            <th class="ship"><span class="nobr">Ship to</span></th>
                            <th><span class="nobr">Total</span></th>
                            <th colspan="2" class="status"><span class="nobr">Status</span></th>
                        </tr>
                    </thead>
                    
                    <tbody>
                        <tr class="order">
                            <td>1262</td>
                            <td><time>July 27, 2012</time></td>
                            <td class="ship"><address>Mark Valasco, Calvarey 121 Street # 45 Antartica Building, West Java, Farmville Town.</address></td>
                            <td>$175.00</td>
                            <td>on-hold</td>
                            <td><a href="#" class="button">View</a></td>
                        </tr>
                        <tr class="order">
                            <td>1262</td>
                            <td><time>July 27, 2012</time></td>
                            <td class="ship"><address>Mark Valasco, Calvarey 121 Street # 45 Antartica Building, West Java, Farmville Town.</address></td>
                            <td>$175.00</td>
                            <td>on-hold</td>
                            <td><a href="#" class="button">View</a></td>
                        </tr>
                        <tr class="order">
                            <td>1262</td>
                            <td><time>July 27, 2012</time></td>
                            <td class="ship"><address>Mark Valasco, Calvarey 121 Street # 45 Antartica Building, West Java, Farmville Town.</address></td>
                            <td>$175.00</td>
                            <td>on-hold</td>
                            <td><a href="#" class="button">View</a></td>
                        </tr>
                    </tbody>
                </table>
                <br>

                <h3>User Info</h3>	
                <p>The following Information will be used on the checkout page by default.</p>
                
                <div class=" one_half firstcols">
					<header class="title2">				
                        <h4>User Information</h4>
                        <a href="#" class="edit">Edit</a>	
                    </header>
                    <div class="clear"></div>
					<address>
						${user.firstName} ${user.lastName}<br>
 						${user.email}<br>
						${user.cardNumber} ${user.cardType}<br>
                        ${user.expDate}<br>
                     </address>   				
                    
                </div>
                <div class="one_half lastcols">
					<header class="title2">				
                        <h4>User Address</h4>
                        <a href="#" class="edit">Edit</a>	
                    </header>
                    <div class="clear"></div>
                    <c:forEach items="${address}" var="addr">
					    ${addr.streetNo} ${addr.streetName}<br>
 						${addr.city} ${addr.state} - ${addr.zip}<br>
						${addr.phone}<br> 
                     </c:forEach>
                </div>
                      
                <div class="clear"></div><!-- clear float --> 
            </section>
            </div>
        </div>
        <!-- END MAIN CONTENT -->
 <%@include file="footer.jsp" %>  
