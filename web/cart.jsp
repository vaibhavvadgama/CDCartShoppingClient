<%-- 
    Document   : cart
    Created on : Oct 18, 2012, 5:50:20 PM
    Author     : Utkarsh
--%>

<%@include file="header.jsp" %>
 <!-- BEFORE CONTENT -->
        <div id="outerbeforecontent">
        	<div class="container">
                <section id="beforecontent" class="twelve columns">
                    <h1 class="pagetitle">Cart</h1>
                    <div class="clear"></div>
                </section>
            </div>
        </div>
        <!-- END BEFORE CONTENT -->
        
        <!-- MAIN CONTENT -->
        <div id="outermain">
        	<div class="container">
			<section id="maincontent" class="twelve columns">
            
				<div id="cart">
                <form action="CartServlet" method="post" />
                <table>
                	<thead>
                        <tr>                            
                            <th class="product">Product</th>
                            <th class="desc">Description</th>
                            <th class="unit-price">Price</th>
                            <th class="remove"></th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <td class="rounded-foot" colspan="3">
                                <input type="hidden" value="checkout" name="action"/>                                <a href="ProductServlet?action=showcategories" class="checkout-button button alt">Add More Items</a><br>                   
                                
                                
                            </td>
                            <td class="rounded-foot" colspan="3">
                            <input type="submit" class="checkout-button button alt" value="Proceed to Checkout" />
                            </td>
                        </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach items="${cartItems}" var="cart"> 
                    
                    <tr>
                        
                        <td class="product"><img src="./${cart.cdImage}" alt="${cart.cdTitle}" width="50px" height="50px"/></td>
                        <td class="desc">${cart.cdTitle}</td>
                        <td class="unit-price">$${cart.cdPrice} </td>
                        <td class="remove"><a class="remove" title="Remove this item" href="CartServlet?action=removeitem&cdid=${cart.cdId}">X</a></td>
                        
                    </tr>
                     </c:forEach>
                    </tbody>
                </table>
                </form>
                </div>
                
               <br><br>

                <div class="cart_totals">
                  <h2>Cart Totals</h2>
                  <table cellspacing="0" cellpadding="0">
                    <tbody>        
                        <tr class="total">
                            <th>Total (tax incl.):</th>
                            <td>$${totalprice}</td>
                        </tr>
                    </tbody>
                  </table> 
                </div>
                                         
                <div class="clear"></div><!-- clear float --> 
            </section>
            </div>
        </div>
        <!-- END MAIN CONTENT -->
 <%@include file="footer.jsp" %>  