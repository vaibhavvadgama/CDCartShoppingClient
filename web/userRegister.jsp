<%-- 
    Document   : userRegister
    Created on : Oct 14, 2012, 12:12:16 AM
    Author     : Utkarsh
--%>

<%-- 
    Document   : index
    Created on : Oct 12, 2012, 6:10:15 PM
    Author     : Utkarsh
--%>

<%@include file="header.jsp" %>
 <!-- BEFORE CONTENT -->
        <div id="outerbeforecontent">
        	<div class="container">
                <section id="beforecontent" class="twelve columns">
                    <h1 class="pagetitle">Register</h1>
                    <div class="clear"></div>
                </section>
            </div>
        </div>
        <!-- END BEFORE CONTENT -->
        
        <!-- MAIN CONTENT -->
        <div id="outermain">
        	<div class="container">
        	<section id="maincontent" class="twelve columns checkout">
            	<form action="UserServlet" method="post">
                <input type="hidden" name="action" value="register" />
            	<div class="six columns alpha">
				<h4>User Information</h4>
                                <c:if test="${error!=''}"><span class="error">${error}</span><br /></c:if>
                <div class="three columns alpha">
					<label for="billing_first_name" class="">First Name <span class="required">*</span></label>
					<input type="text" class="input-text" name="firstName" id="billing_first_name" placeholder="First Name" value="" />
				</div> 
                <div class="three columns omega">
					<label for="billing_last_name" class="">Last Name <span class="required">*</span></label>
					<input type="text" class="input-text" name="lastName" id="billing_last_name" placeholder="Last Name" value="" />
				</div>
                <div class="three columns alpha">
					<label for="billing_first_name" class="">Email<span class="required">*</span></label>
					<input type="text" class="input-text" name="email" id="billing_first_name" placeholder="Email" value="" />
				</div>
                <div class="three columns omega">
					<label for="billing_last_name" class="">Password<span class="required">*</span></label>
					<input type="password" class="input-text" name="pass" id="billing_last_name" placeholder="Password" value="" />
				</div>
                <div class="three columns alpha">
					<label for="billing_first_name" class="">Confirm Password<span class="required">*</span></label>
					<input type="password" class="input-text" name="cpass" id="billing_first_name" placeholder="Confirm Password" value="" />
				</div>                
                <div class="clear"></div>            
					
				
                <div class="three columns alpha">
               <input type="submit" class="button" value="Register" />
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