<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="true"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<c:if test="${ !empty sessionScope.lgadmin}">
	<div class="alert alert-danger">
		${ sessionScope.lgadmin }
	</div>
	<c:remove var="lgadmin" scope="session" />
</c:if>


	<!-- Slide show -->
		    <div id="carouselExampleDark" class="carousel carousel-light slide" data-bs-ride="carousel">
		      <div class="carousel-indicators">
		        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-label="Slide 1" aria-current="true"></button>
		        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2" class=""></button>
		        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3" class="" ></button>
		      </div>
		      <div class="carousel-inner" style="background-color:black;">
		        <div class="carousel-item active" data-bs-interval="10000">
		    		<video autoplay="" muted="" loop="" style=" height:730px; " class="offset-1">
						<source src="/su22b1_it16304_sof3021/images/products/videoxe.mp4" type="video/mp4">
				   </video>
		          <div class="carousel-caption d-none d-md-block">
		            <h5>First slide label</h5>
		            <p>Some representative placeholder content for the first slide.</p>
		          </div>
		        </div>
		        <div class="carousel-item" data-bs-interval="5000">
		          
		          <div style=" height:730px;text-align: center ">
		          	<img alt="" src="/su22b1_it16304_sof3021/images/products/sp1.jpg" style=" height:100%; ">
		          	<img alt="" src="/su22b1_it16304_sof3021/images/products/sp2.jpg" style=" height:100%; ">
		          </div>
		    
		          <div class="carousel-caption d-none d-md-block">
		            <h5>Second slide label</h5>
		            <p>Some representative placeholder content for the second slide.</p>
		          </div>
		        </div>
		        <div class="carousel-item " data-bs-interval="5000">
		          
		          <div style=" height:730px; text-align: center">
		          	<img alt="" src="/su22b1_it16304_sof3021/images/products/sp3.jpg" style=" height:100%; ">
		          	<img alt="" src="/su22b1_it16304_sof3021/images/products/sp4.jpg" style=" height:100%; ">
		          </div>
		          
		          <div class="carousel-caption d-none d-md-block">
		            <h5>Third slide label</h5>
		            <p>Some representative placeholder content for the third slide.</p>
		          </div>
		        </div>
		      </div>
		      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
		        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		        <span class="visually-hidden">Previous</span>
		      </button>
		      <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
		        <span class="carousel-control-next-icon" aria-hidden="true"></span>
		        <span class="visually-hidden">Next</span>
		      </button>
		    </div>
		    <!--End Slide show -->
		    
		    
<article class="pt-4 pb-4">
    <div class="row">
    <!-- slide -->
        <div id="carouselExampleControls" class="carousel slide p-0 col-12 col-md-8 ms-md-5" data-bs-ride="carousel">
            <div class="carousel-indicators" style="bottom: 50px;">
                <button type="button" data-bs-target="#carouselExampleControls" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleControls" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleControls" data-bs-slide-to="2" aria-label="Slide 3"></button>
                </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                <img src="images/Banner-LP-Tuyen-sinh-7-2016-1.jpg" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                <img src="images/Banner-web-Chuyen-truong-Chuyen-hoc-phi-11.jpg" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                <img src="images/Banner-hocnhunggidoanhnghiepcan.jpg" class="d-block w-100" alt="...">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    <!-- /slide -->
        
        <div class="card col-md-3 col-10 offset-7 p-0 m-auto mt-0 ms-md-3 ">
            <div class="card-header" data-bs-toggle="collapse" data-bs-target="#Danhmuc" style="color: black;">
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-list-ul" viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M5 11.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm-3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm0 4a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm0 4a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
                </svg>
                <Strong>Danh m???c</Strong>
            </div> 
            <div class="list-group list-group-flush collapse show " id="Danhmuc">
                <a class="list-group-item list-group-item-action" href="">L???p tr??nh android n??ng cao</a>
                <a class="list-group-item list-group-item-action" href="">X??y d???ng trang web/a>
                <a class="list-group-item list-group-item-action" href="">C?? s??? d??? li???u</a>
                <a class="list-group-item list-group-item-action" href="">Internet marketting</a>
                <a class="list-group-item list-group-item-action" href="">L???p tr??nh h?????ng ?????i t?????ng v???i java</a>
                <a class="list-group-item list-group-item-action" href="">L???p tr??nh PHP</a>
                <a class="list-group-item list-group-item-action" href="">??i???n to??n ????m m??y</a>
                <a class="list-group-item list-group-item-action" href="">L???p tr??nh game 2D</a>
                <a class="list-group-item list-group-item-action" href="">L???p tr??nh ASP.NET</a>
                <a class="list-group-item list-group-item-action" href="">Thi???t k??? giao di???n ??i???n tho???i </a>
            </div>
        </div>

    <!-- Offcanvas User -->
    <div class="offcanvas offcanvas-start" style="width: 250px;"  data-bs-scroll="true" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasWithBothOptionsLabel">
        <div class="offcanvas-header">
            <h5 id="offcanvasTitle">User</h5>
            <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <div class="offcanvas-body">
            <!-- content here! -->
        </div>
    </div>
    <!-- /Offcanvas User -->
    <div class="row mt-4 p-4 col-11" style="margin: auto; box-shadow: 0 0 1px black; border-radius: 5px;">
        <h1 class="text-center">M??n h???c y??u th??ch nh???t</h1>
        <div class="card col-md-3 col-12 text-center p-3" style="margin:auto;">
            <a href=""><img src="https://www.garena.vn/img/esports_icon@2x.7e8e90ee.png" class="card-img-top" style="width: 70%;" alt="..."></a>
            <div class="card-body">
                <a href="#tracnghiem" type="button" ng-click="quizStart()"  class="btn btn-primary">L??m b??i quiz</a>
            </div>
        </div>
        <div class="card col-md-3 col-12 text-center p-3" style="margin:auto;">
            <a href=""><img src="https://www.garena.vn/img/games_icon@2x.d85172d7.png" class="card-img-top" style="width: 70%;" alt="..."></a>
            <div class="card-body">
                <a href="#tracnghiem" type="button" ng-click="quizStart()" class="btn btn-primary">L??m b??i quiz</a>
            </div>
        </div>
        <div class="card col-md-3 col-12 text-center p-3" style="margin:auto;">
            <a href=""><img src="https://www.garena.vn/img/community_icon@2x.a3ef0053.png" class="card-img-top" style="width: 70%;" alt="..."></a>
            <div class="card-body">
                <a href="#tracnghiem" type="button" ng-click="quizStart()" class="btn btn-primary">L??m b??i quiz</a>
            </div>
        </div>
    </div>
</article>
<aside >
    <h1 class="text-center">M??n h???c ph??? bi???n</h1>
    <div class="row p-5" style="background-color: #33909f75;">
        <img src="images/img.jfif"  class="card-img-left col-md-4 col-12" alt="">
        <div class="card-body col-md-4 col-12 offset-1">
            <h2>???NG D???NG PH???N M???M</h2>
            <h3>N???I DUNG ????O T???O</h3>
            <ul>
                <li>L???p tr??nh Java t??? c?? b???n ?????n n??ng cao, t??? window form ?????n web form</li>
                <li>Ki???m th??? ph???n m???m t??? c?? b???n ?????n n??ng cao</li>
                <li>M???ng m??y t??nh c?? b???n</li>
                <li>Tri???n khai c??c ph???n m???m m?? ngu???n m???, ph???n m???m h?????ng d???ch v??? Software as a Service, ??i???n to??n ????m m??y, marketing tr??n Internet</li>
                <li>Qu???n tr??? d??? ??n c??ng ngh??? th??ng tin</li>
                <li>Qu???n tr??? c?? s??? d??? li???u</li>
                <li>K??? n??ng m???m v?? ngo???i ng???: k??? n??ng giao ti???p, thuy???t tr??nh, k??? n??ng l??m vi???c nh??m, k??? n??ng x??? l?? t??nh hu???ng ph??t sinh trong qu?? tr??nh th???c hi???n c??ng vi???c, ti???ng Anh giao ti???p.</li>
            </ul>
            <a href="#" type="button" class="btn btn-primary">Chi ti???t kh??a h???c</a>
        </div>
    </div>
    <div class="row p-5" style="background-color: #5c5c5c54;">
        <div class="card-body col-md-4 col-12 ">
            <h2>???NG D???NG PH???N M???M</h2>
            <h3>N???I DUNG ????O T???O</h3>
            <ul>
                <li>L???p tr??nh Java t??? c?? b???n ?????n n??ng cao, t??? window form ?????n web form</li>
                <li>Ki???m th??? ph???n m???m t??? c?? b???n ?????n n??ng cao</li>
                <li>M???ng m??y t??nh c?? b???n</li>
                <li>Tri???n khai c??c ph???n m???m m?? ngu???n m???, ph???n m???m h?????ng d???ch v??? Software as a Service, ??i???n to??n ????m m??y, marketing tr??n Internet</li>
                <li>Qu???n tr??? d??? ??n c??ng ngh??? th??ng tin</li>
                <li>Qu???n tr??? c?? s??? d??? li???u</li>
                <li>K??? n??ng m???m v?? ngo???i ng???: k??? n??ng giao ti???p, thuy???t tr??nh, k??? n??ng l??m vi???c nh??m, k??? n??ng x??? l?? t??nh hu???ng ph??t sinh trong qu?? tr??nh th???c hi???n c??ng vi???c, ti???ng Anh giao ti???p.</li>
            </ul>
            <a href="#" type="button" class="btn btn-primary">Chi ti???t kh??a h???c</a>
        </div>
        <img src="images/FPTPolytechnic_vitrinaochosinhvienlaptrinhweb_0.jpg"  class="card-img-left col-md-4 col-12" alt="">
    </div>
    <div class="row p-5" style="background-color: #33909f75;">
        <img src="images/Mobile-Application-Development-???-Offering-Great-Prospects-Blog-Featured-Image-500x295.jpg"  class="card-img-left col-md-4 col-12 " alt="">
        <div class="card-body col-md-4 col-12 offset-1">
            <h2>???NG D???NG PH???N M???M</h2>
            <h3>N???I DUNG ????O T???O</h3>
            <ul>
                <li>L???p tr??nh Java t??? c?? b???n ?????n n??ng cao, t??? window form ?????n web form</li>
                <li>Ki???m th??? ph???n m???m t??? c?? b???n ?????n n??ng cao</li>
                <li>M???ng m??y t??nh c?? b???n</li>
                <li>Tri???n khai c??c ph???n m???m m?? ngu???n m???, ph???n m???m h?????ng d???ch v??? Software as a Service, ??i???n to??n ????m m??y, marketing tr??n Internet</li>
                <li>Qu???n tr??? d??? ??n c??ng ngh??? th??ng tin</li>
                <li>Qu???n tr??? c?? s??? d??? li???u</li>
                <li>K??? n??ng m???m v?? ngo???i ng???: k??? n??ng giao ti???p, thuy???t tr??nh, k??? n??ng l??m vi???c nh??m, k??? n??ng x??? l?? t??nh hu???ng ph??t sinh trong qu?? tr??nh th???c hi???n c??ng vi???c, ti???ng Anh giao ti???p.</li>
            </ul>
            <a href="#" type="button" class="btn btn-primary">Chi ti???t kh??a h???c</a>
        </div>
    </div>
</aside>
		    