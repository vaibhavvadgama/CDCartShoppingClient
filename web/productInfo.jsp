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
                    <h1 class="pagetitle">${proddata.cdTitle}</h1>
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
               	  <div class="padcontent product-detail">
                    	<div class="four columns alpha">
                       		<img src="./${proddata.cdImage}" alt="" class="imgborder scale-with-grid" />
                        </div>
                        <div class="one_half lastcols">
                            
                            <div class="price">$${proddata.cdPrice}</div>
                            <p>Donec consectetur libero ut tortor condimentum eu egestas est viverra. Sed eget turpis dui, sed auctor nisi. Fusce suscipit risus sed tortor mattis sollicitudin. </p>
                            <div class="variations_button">
                            	<form class="variations_form cart" method="post" action="cart.html">
                                  <div class="quantity buttons_added"></div>	
                                    <button class="button alt" type="submit">Add to cart</button>	
                                </form>			
                    
								<div class="product_meta"></div>
                            </div>
                        </div>
                        <div class="clear"></div><br><br>
                        <div class="separator line"></div>
                        
                        <h3>&nbsp;</h3> 
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
                                    <h3><a href="product-details.html">Smart Strip Armchair</a></h3>
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
                                    <h3><a href="product-details.html">Smart Chair</a></h3>
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
                                    <h3><a href="product-details.html">Smart Camera SLR</a></h3>
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