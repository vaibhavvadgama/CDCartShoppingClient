<%-- 
    Document   : userLogin
    Created on : Oct 14, 2012, 12:12:01 AM
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
				<section id="content" class="positionleft nine columns alpha"> 
                	<div class="padcontent">
                    	
                        <div class="one_half firstcols">
                            <h2 class="title">Create your account</h2>
                            <h5><a href="UserServlet?action=userregister">Click Here</a></h5>
                            
                        </div>
                        <div class="one_half lastcols">
                            <h2 class="title">Already Registered?</h2>
                            <form method="post" action="UserServlet" id="loginform">
                            <input type="hidden" name="action" value="login" />
                            <fieldset>
                            <label>E-mail Address</label><br />
                            <input type="text" name="email"/><br />
                            <label>Password</label><br />
                            <input type="password" class="text-input" name="pass"/><br />
                            <input type="submit" class="button" value="log in" />
                            </fieldset>
                            </form>
                        </div>
                                        
                	</div>
                </section>
                <aside id="sidebar" class="positionright three columns omega">
                    <ul>
                         <li class="widget-container">
                            <h2 class="widget-title">Categories</h2>
                            <ul>
                                <li><a href="#">Limited Edition</a><span>15</span></li>
                                <li><a href="#">On Sale</a><span>27</span></li>
                                <li><a href="#">New Product</a><span>10</span></li>
                                <li><a href="#">Furniture</a><span>23</span></li>
                                <li><a href="#">Electronic</a><span>25</span></li>
                                <li><a href="#">Other</a><span>70</span></li>
                            </ul>
                        </li>
                        <li class="widget-container">
                            <div class="textwidget"><img src="images/content/banner.gif" alt="" class="scale-with-grid"/></div>
                        </li>
                        <li class="widget-container">
                            <h2 class="widget-title">Top Rated Product</h2>
                            <ul class="lp-widget">
                                <li>
                                    <img src="images/content/product/small-img1.jpg" alt="" class="alignleft imgborder" />
                                    <h3><a href="#">Smart Strip Armchair</a></h3>
                                    <div class="price">$120.00</div>
                                    <div class="star">
                                        <img src="images/content/star.png" alt=""/>
                                        <img src="images/content/star.png" alt="" />
                                        <img src="images/content/star.png" alt="" />
                                    </div>
                                    <div class="clear"></div>
                                </li>
                                <li>
                                    <img src="images/content/product/small-img2.jpg" alt="" class="alignleft imgborder" />
                                    <h3><a href="#">Smart Chair</a></h3>
                                    <div class="price">$200.00</div>
                                    <div class="star">
                                        <img src="images/content/star.png" alt=""/>
                                        <img src="images/content/star.png" alt="" />
                                        <img src="images/content/star.png" alt="" />
                                        <img src="images/content/star.png" alt="" />
                                    </div>
                                    <div class="clear"></div>
                                </li>
                                <li>
                                    <img src="images/content/product/small-img3.jpg" alt="" class="alignleft imgborder" />
                                    <h3><a href="#">Smart Camera SLR</a></h3>
                                    <div class="price">$120.00</div>
                                    <div class="star">
                                        <img src="images/content/star.png" alt=""/>
                                        <img src="images/content/star.png" alt="" />
                                        <img src="images/content/star.png" alt="" />
                                        <img src="images/content/star.png" alt="" />
                                    </div>
                                    <div class="clear"></div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </aside>
                                
                <div class="clear"></div><!-- clear float --> 
            </section>
            </div>
        </div>
        <!-- END MAIN CONTENT -->
 <%@include file="footer.jsp" %>  