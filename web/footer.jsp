<%-- 
    Document   : footer
    Created on : Oct 13, 2012, 12:48:55 AM
    Author     : Utkarsh
--%>



        
<!-- FOOTER SIDEBAR -->
        <div id="outerfootersidebar">
        	<div class="container">
                <div id="footersidebarcontainer" class="twelve columns"> 
                    <footer id="footersidebar">
                    <div id="footcol1"  class="three columns alpha">
                    	<ul>
                          	<li class="widget-container">
                            <h2 class="widget-title">Recent Post</h2>
                            <ul class="ts-recent-post-widget">
                            	<li>
                                	<img src="./images/content/rp1.jpg" alt="">
                                    <h3><a href="#">Page Title</a></h3>
                                    <span>Pellentesque ac ante arcu. Mauris quis nunc et.</span>
                                    <div class="clear"></div>
                                </li>
                            	<li>
                                	<img src="./images/content/rp2.jpg" alt="">
                                    <h3><a href="#">Page Title</a></h3>
                                    <span>Pellentesque ac ante arcu. Mauris quis nunc et.</span>
                                    <div class="clear"></div>
                                </li>
                            	<li>
                                	<img src="./images/content/rp3.jpg" alt="">
                                    <h3><a href="#">Page Title</a></h3>
                                    <span>Pellentesque ac ante arcu. Mauris quis nunc et.</span>
                                    <div class="clear"></div>
                                </li>
                            </ul>
                            </li>
                    	</ul>
                    </div>
                    <div id="footcol2"  class="three columns">
                        <ul>
                          	<li class="widget-container">
                            	<h2 class="widget-title">Latest Tweet</h2>
                            	<div id='userandquery' class="query"></div>
                            </li>
                        </ul>
                    </div>
                    <div id="footcol3"  class="three columns">
                        <ul>
                            <li class="widget-container">
                                <h2 class="widget-title">Our Gallery</h2>
                                <div class="gallery-pic">
                                	<a href="#"><img src="./images/content/small-g1.jpg" alt=""></a>
                                    <a href="#"><img src="./images/content/small-g2.jpg" alt=""></a>
                                    <a href="#"><img src="./images/content/small-g3.jpg" alt=""></a>
                                    <a href="#"><img src="./images/content/small-g4.jpg" alt="" class="nomargin"></a>
                                    <a href="#"><img src="./images/content/small-g5.jpg" alt=""></a>
                                    <a href="#"><img src="./images/content/small-g6.jpg" alt=""></a>
                                    <a href="#"><img src="./images/content/small-g7.jpg" alt=""></a>
                                    <a href="#"><img src="./images/content/small-g8.jpg" alt="" class="nomargin"></a>
                                </div>
                                <div class="clear"></div>
                            </li>
                        </ul>
                    </div>
                    <div id="footcol4"  class="three columns omega">
                        <ul>
                            <li class="widget-container">
                                <h2 class="widget-title">SmartShop</h2>
                                <p>Pellentesque ac ante arcu. Mauris quis nunc velit. Praesent hendrerit bibendum libero, vitae fermentum eros bibendum eget. Morbi molestie volutpat elementum. </p>
								<p>Etiam at erat tortor. Etiam vel ipsum eros. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam eu ligula metus, eu gravida lorem. </p>
                            </li>
                        </ul>
                    </div>
                    <div class="clear"></div>
                    </footer>
                    
                </div>
            </div>
        </div>
        <!-- END FOOTER SIDEBAR -->
        
        <!-- FOOTER -->
        <div id="outerfooter">
        	<div class="container">
        	<div id="footercontainer" class="twelve columns">
            	<footer id="footer">Copyright &copy;2012 SmartShop. All Rights Reserved . Theme design by <a href="../../templatesquare.com/default.htm">TemplateSquare.com</a></footer>
                <ul class="sn">
                    <li><a href="../../pinterest.com/default.htm" title="Pinterest"><span class="icon-img" style="background:url(./images/social/pinterest.png)"></span></a></li>
                    <li><a href="../../plus.google.com/default.htm" title="Google Plus"><span class="icon-img" style="background:url(./images/social/gplus.png)"></span></a></li>
                    <li><a href="../../facebook.com/default.htm" title="Facebook"><span class="icon-img" style="background:url(./images/social/facebook.png)"></span></a></li>
                    <li><a href="../../twitter.com/default.htm" title="Twitter"><span class="icon-img" style="background:url(./images/social/twitter.png)"></span></a></li>
                </ul>
            </div>
            </div>
        </div>
        <!-- END FOOTER -->
        
	</div><!-- end bodychild -->
</div><!-- end outercontainer -->

<!-- ////////////////////////////////// -->
<!-- //      Javascript Files        // -->
<!-- ////////////////////////////////// -->


<!-- jQuery Superfish -->
<script type="text/javascript" src="./js/hoverIntent.js"></script> 
<script type="text/javascript" src="./js/superfish.js"></script> 
<script type="text/javascript" src="./js/supersubs.js"></script>

<!-- jQuery Flexslider -->
<script type="text/javascript" src="./js/jquery.flexslider-min.js"></script>

<!-- jQuery Dropdown Mobile -->
<script type="text/javascript" src="./js/tinynav.min.js"></script>

<!-- Custom Script -->
<script type="text/javascript" src="./js/custom.js"></script>

<!-- Twitter Script -->
<script type="text/javascript" src="./js/jquery.tweet.js" ></script>

<script type="text/javascript">
jQuery(window).load(function() {
	//Slider
	jQuery('.flexslider').flexslider({
          animation: "fade"
    	});
		
	//Carousel
	jQuery('.flexslider-carousel').flexslider({
	  animation: "slide",
	  animationLoop: false,
	  itemWidth: 220,
	  minItems: 2,
	  maxItems: 4,

	});
		
});

jQuery(document).ready(function() {
	//Twitter
	jQuery("#userandquery").tweet({
	  count: 2,
	  username: "templatesquare",
	  loading_text: "searching twitter..."
	});
});
</script>	

<!-- Demo Switcher -->
<script type="text/javascript" src="./js/jquery.cookie.js"></script>
<script type="text/javascript" src="./js/switcher.js"></script>


</body>
</html>
