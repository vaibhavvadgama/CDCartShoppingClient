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
                    <h1 class="pagetitle">All Products</h1>
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

                      <div id="ts-display-products">
                          <ul class="ts-display-pd-col-3">
                              <c:forEach items="${products}" var="prod">
                              <li>
                                  <a href="ProductServlet?action=showproductinfo&prodId=${prod.cdId}"><img src="./${prod.cdImage}" alt="" class="scale-with-grid imgborder" />
                                  <h2><a href="ProductServlet?action=showproductinfo&prodId=${prod.cdId}">${prod.cdTitle}</a></h2>                                
                                  <div class="price">$${prod.cdPrice}</div>
                                  </a>
                              </li>
                              </c:forEach>
                          </ul>
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
                            <h2 class="widget-title">Text Widget</h2>
                            <div class="textwidget">Pellentesque at mauris fringilla nunc sollicitudin vehicula. Aliquam et nibh ipsum, vel porta augue. Sed dolor ligula, facilisis.</div>
                        </li>
                        <li class="widget-container">
                            <div class="textwidget"><img src="images/content/banner.gif" alt="" class="scale-with-grid"/></div>
                        </li>
                        
                    </ul>
                </aside>
                                
                <div class="clear"></div><!-- clear float --> 
            </section>
            </div>
        </div>
        <!-- END MAIN CONTENT -->
 <%@include file="footer.jsp" %>  