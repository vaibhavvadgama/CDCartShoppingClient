<%-- 
    Document   : confirmorder
    Created on : Oct 18, 2012, 5:51:50 PM
    Author     : Utkarsh
--%>

<%@include file="header.jsp" %>
<div id="outermain">
        	<div class="container">
			<section id="maincontent" class="twelve columns">
				<section id="content" class="positionleft nine columns alpha"> 
                	<div class="padcontent">
                        <c:if test="${payment=='true'}">
                        <div class="alert">
                           Thanks for your order.It will be delivered in 3-5 business days.
                           <a href="ProductServlet?action=showcategories">Back to home page.</a>                            
                        </div>
                        </c:if>
                        <c:if test="${payment=='false'}">
                        <div class="alert">
                           Sorry there is problem with your payment.Your order can not be processed.
                           <a href="ProductServlet?action=showcategories">Back to home page.</a>                            
                        </div>
                        </c:if>
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