<%-- 
    Document   : checkout
    Created on : Oct 18, 2012, 5:51:23 PM
    Author     : Utkarsh
--%>

<%@include file="header.jsp" %>
  <!-- BEFORE CONTENT -->
        <div id="outerbeforecontent">
        	<div class="container">
                <section id="beforecontent" class="twelve columns">
                    <h1 class="pagetitle">Add Address</h1>
                    <div class="clear"></div>
                </section>
            </div>
        </div>
        <!-- END BEFORE CONTENT -->
        
        <!-- MAIN CONTENT -->
        <div id="outermain">
        	<div class="container">
        	<section id="maincontent" class="twelve columns checkout">
            	<form action="CartServlet" method="post">
                <input type="hidden" name="userid" value="${userId}" />
                <input type="hidden" name="action" value="confirmorder" />
            	<div class="six columns alpha">
				<h4>Address</h4>
                      <input type="hidden" class="input-text" name="addrtype" value="ship" />      
                <div class="three columns alpha">
					<label for="billing_first_name" class="">Street No<span class="required">*</span></label>
					<input type="text" class="input-text" name="streetno" id="streetno" placeholder="streetno" value="" />
				</div>
                <div class="three columns omega">
					<label for="billing_last_name" class="">Street Name<span class="required">*</span></label>
					<input type="text" class="input-text" name="streetname" id="streetname" placeholder="streetname" value="" />
				</div>
                <div class="three columns alpha">
					<label for="billing_first_name" class="">City<span class="required">*</span></label>
					<input type="text" class="input-text" name="city" id="city" placeholder="city" value="" />
				</div>
                <div class="three columns omega">
					<label for="billing_last_name" class="">State<span class="required">*</span></label>
					<input type="text" class="input-text" name="state" id="state" placeholder="state" value="" />
				</div>
                <div class="three columns alpha">
					<label for="billing_first_name" class="">Zip<span class="required">*</span></label>
					<input type="text" class="input-text" name="zip" id="zip" placeholder="zip" value="" />
				</div>
                <div class="three columns alpha">
					<label for="billing_first_name" class="">Phone<span class="required">*</span></label>
					<input type="text" class="input-text" name="phone" id="phone" placeholder="phone" value="" />
				</div>                  
                <div class="clear"></div>
                <h4>Payment Info</h4>
                <div class="six columns alpha">
					<label for="billing_company" class="">Card Number</label>
					<input type="text" class="input-text" name="cardNum" id="billing_company" placeholder="Card Number" value="" />
				</div>
                <div class="three columns alpha">
					<label for="billing_address_1" class="">Card type<span class="required">*</span></label>
					<select name="cardType" class="input-text"><option value="visa">Visa</option><option value="master">Master</option><option value="amex">American Express</option></select>
				</div>
                <div class="three columns omega">
					<label for="billing_address_2" class="hidden">Cvv</label>
					<input type="password" class="input-text" name="cardCvv" id="billing_address_2" placeholder="Cvv" value="" />
				</div>
                <div class="clear"></div>
                <div class="three columns alpha">
					<label for="billing_city" class="">Expiry date<span class="required">*</span></label>
					<input type="text" class="input-text" name="cardDate" id="billing_city" placeholder="MM/YY" value="" />
				</div>
                <div class="three columns alpha">
					<label for="billing_address_1" class="">Payment<span class="required">*</span></label>
					<select name="payment" class="input-text"><option value="true">True</option><option value="false">False</option></select>
				</div>
                <div class="three columns alpha">
               <input type="submit" class="button" value="Confirm Order" />
               </div></div>
               
                </form>
                
                <div class="clear"></div>	
                </div>
                
               
                <div class="clear"></div><br><br>

                
                        <div class="clear"></div>
                    </div>

                
                <div class="clear"></div><!-- clear float --> 
            </section>
            </div>
        </div>
        <!-- END MAIN CONTENT -->
 <%@include file="footer.jsp" %>  