<%-- 
    Document   : index
    Created on : Oct 12, 2012, 6:10:15 PM
    Author     : Utkarsh
--%>

<%@include file="header.jsp" %>
  <!-- MAIN CONTENT -->
        <div id="outermain">
        	<div class="container">
        	<section id="maincontent" class="twelve columns">
            
            	<section class="maincarousel">
                    <h2>Available Categories</h2>
                    <h5>Cd Category List</h5><br>
                    
                    <!--<div class="flexslider-carousel">
                        <ul class="slides">
                            <li><a href="product-details.html"><img src="./images/content/product/img1.jpg" alt="" class="scale-with-grid" /></a>
                            	<h2><a href="product-details.html">Smart Table</a></h2>
								<div class="price">$175.00</div>
                            </li>
                            <li><a href="product-details.html"><img src="./images/content/product/img2.jpg" alt="" class="scale-with-grid"/></a>
                            	<div class="ribbon-new"></div>
                            	<h2><a href="product-details.html">Smart Chair</a></h2>
								<div class="price">$250.00</div>
                            </li>
                            <li><a href="product-details.html"><img src="./images/content/product/img3.jpg" alt="" class="scale-with-grid"/></a>
                            	<h2><a href="product-details.html">Smart Desk Lamp</a></h2>
								<div class="price">$75.00</div>
                            </li>
                            <li><a href="product-details.html"><img src="./images/content/product/img4.jpg" alt="" class="scale-with-grid"/></a>
                            	<h2><a href="product-details.html">Smart Strip Armchair</a></h2>
								<div class="price">$250.00</div>
                            </li>
                            
                            <li><a href="product-details.html"><img src="./images/content/product/img5.jpg" alt="" class="scale-with-grid"/></a>
                            	<h2><a href="product-details.html">Smart Table</a></h2>
								<div class="price">$175.00</div>
                            </li>
                            <li><a href="product-details.html"><img src="./images/content/product/img6.jpg" alt="" class="scale-with-grid"/></a>
                            	<h2><a href="product-details.html">Smart Chair</a></h2>
								<div class="price">$250.00</div>
                            </li>
                            <li><a href="product-details.html"><img src="./images/content/product/img7.jpg" alt="" class="scale-with-grid"/></a>
                            	<h2><a href="product-details.html">Smart Desk Lamp</a></h2>
								<div class="price">$75.00</div>
                            </li>
                            <li><a href="product-details.html"><img src="./images/content/product/img4.jpg" alt="" class="scale-with-grid"/></a>
                            	<h2><a href="product-details.html">Smart Strip Armchair</a></h2>
								<div class="price">$250.00</div>
                            </li>
                        </ul>
                    </div>-->
				</section>
                <div class="clear"></div><!-- clear float --> 
                <div class="separator line"></div><br>
                <!-- Content Div for Cart -->
                <div align="center">
                    
                    
                    <table width="200" border="0">
                     <c:forEach items="${categories}" var="cat">
                      <tr>
                        <td><a href="ProductServlet?action=showProducts&catid=${cat.categoryId}">${cat.categoryName}</a></td>
                      </tr>
                      </c:forEach>
                    </table>

                    
                    
                </div>
                
                
                <!-- End content Div for Cart -->  
                
               <!-- <div class="six columns alpha">
                	<h2>About Us</h2>
                	<img src="./images/content/icon1.png" alt="" class="alignleft">
                	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ultrices dui eu lectus fringilla non pellentesque magna egestas. Suspendisse potenti. Vivamus at magna libero. Donec et purus nunc, eu aliquam diam. <br>
Proin tincidunt feugiat pretium. In eget dictum urna. Proin quis leo at mi gravida luctus. Proin tincidunt feugiat pretium. In eget dictum urna. Proin quis leo at mi gravida luctus. </p>
					<a href="about.html" class="button">Read more</a>
                </div>
                <div class="six columns omega">
                	<h2>How We Work</h2>
                	<img src="./images/content/icon2.png" alt="" class="alignleft">
                	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ultrices dui eu lectus fringilla non pellentesque magna egestas. Suspendisse potenti. Vivamus at magna libero. Donec et purus nunc, eu aliquam diam. <br>
Proin tincidunt feugiat pretium. In eget dictum urna. Proin quis leo at mi gravida luctus. Proin tincidunt feugiat pretium. In eget dictum urna. Proin quis leo at mi gravida luctus. </p>
					<a href="about.html" class="button">Read more</a>
                </div>
                <div class="clear"></div><!-- clear float --> <br>
	
                <div class="separator line"></div><br>
                     
            	<!--<section class="maincarousel">
                    <h2>Best Sales</h2>
                    <h5>Donec cursus fringilla aliquet. Nulla ultrices elit ut lorem.</h5><br>
                    
                    <div class="flexslider-carousel">
                        <ul class="slides">
                            <li><a href="product-details.html"><img src="./images/content/product/img7.jpg" alt="" class="scale-with-grid" /></a>
                            	<h2><a href="product-details.html">Smart Oval Sofa</a></h2>
								<div class="price">$175.00</div>
                            </li>
                            <li><a href="product-details.html"><img src="./images/content/product/img6.jpg" alt="" class="scale-with-grid"/></a>
                            	<div class="ribbon-new"></div>
                            	<h2><a href="product-details.html">Vintage Wall Lamp</a></h2>
								<div class="price">$250.00</div>
                            </li>
                            <li><a href="product-details.html"><img src="./images/content/product/img5.jpg" alt="" class="scale-with-grid"/></a>
                            	<h2><a href="product-details.html">Smart Camera SLR</a></h2>
								<div class="price">$75.00</div>
                            </li>
                            <li><a href="product-details.html"><img src="./images/content/product/img4.jpg" alt="" class="scale-with-grid"/></a>
                            	<h2><a href="product-details.html">Smart Strip Armchair</a></h2>
								<div class="price">$250.00</div>
                            </li>
                            
                            <li><a href="product-details.html"><img src="./images/content/product/img3.jpg" alt="" class="scale-with-grid"/></a>
                            	<h2><a href="product-details.html">Smart Desk Lamp</a></h2>
								<div class="price">$175.00</div>
                            </li>
                            <li><a href="product-details.html"><img src="./images/content/product/img2.jpg" alt="" class="scale-with-grid"/></a>
                            	<h2><a href="product-details.html">Smart Chair</a></h2>
								<div class="price">$250.00</div>
                            </li>
                            <li><a href="product-details.html"><img src="./images/content/product/img1.jpg" alt="" class="scale-with-grid"/></a>
                            	<h2><a href="product-details.html">Smart Table</a></h2>
								<div class="price">$75.00</div>
                            </li>
                            <li><a href="product-details.html"><img src="./images/content/product/img4.jpg" alt="" class="scale-with-grid"/></a>
                            	<h2><a href="product-details.html">Smart Strip Armchair</a></h2>
								<div class="price">$250.00</div>
                            </li>
                        </ul>
                    </div>
				</section>
                   
                <div class="clear"></div><!-- clear float --> 
            </section>
            </div>
        </div>
        <!-- END MAIN CONTENT -->
 <%@include file="footer.jsp" %>  