<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>장소추가</title>
    <jsp:include page="/Layouts/resource.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="Layouts/mapstyle.css">
    <script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=df02547fc218af99e9e9d07b3e4b2f6f&libraries=services"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="/Layouts/datepicker-ko.js"></script>
</head>

<body>
    <jsp:include page="/Layouts/nav.jsp"></jsp:include>
    <div class="ui main text container" style="margin-top: 80px;">
        <div class="ui centered align header">
            <div class="ui message box">장소추가</div>
        </div>
        <div class="map_wrap">
            <div id="map" style="width: 100%; height: 60%; position: relative; overflow: hidden;"></div>
            <div id="search_wrap" class="bg_white">
                <div class="option">
                    <div>
                        <form class="ui form" onsubmit="searchPlaces(); return false;">
                            <div class="ui centered align tiny header">
                                <div class="ui tiny message box">검색</div>
                            </div>
                            <input type="text" value="계양구청" id="keyword" size="15">
                            <button class="ui primary tiny button" type="submit"
                                style="margin-top: 10px; margin-bottom: 5px;">검색하기</button>
                        </form>
                    </div>
                </div>
                <hr>
            </div>
            <div id="menu_wrap" class="bg_white">
                <ul id="placesList"></ul>
                <div id="pagination"></div>
            </div>
            <div>
                <form action="/placesave.slp" method="POST" class="ui form" style="padding-bottom: 80px;">
                    <label>장소</label>
                    <input type="text" name="location" id="location" required readonly>
                    <br>
                    <label>주소</label>
                    <input type="text" name="address" id="address" required readonly>
                    <br>
                    <label>참여자</label>
                    <select name="userInfo" id="userInfo" multiple="" class="ui fluid search dropdown" required>
                        <c:forEach items="${requestScope.user}" var="u">
                            <option value="${u.userInfo}">${u.userInfo}</option>
                        </c:forEach>
                    </select>
                    <label>날짜</label>
                    <input type="text" name="rdate" id="rdate" size="12" readonly required>
                    <br>
                    <label>시간</label>
                    <div class="ui two column grid">
                        <div class="column">
                            <select name="hour" id="hour" class="ui fluid dropdown" required>
                                <option value="00">00시</option>
                                <option value="01">01시</option>
                                <option value="03">03시</option>
                                <option value="04">04시</option>
                                <option value="05">05시</option>
                                <option value="06">06시</option>
                                <option value="07">07시</option>
                                <option value="08">08시</option>
                                <option value="09">09시</option>
                                <option value="10">10시</option>
                                <option value="11">11시</option>
                                <option value="12">12시</option>
                                <option value="13">13시</option>
                                <option value="14">14시</option>
                                <option value="15">15시</option>
                                <option value="16">16시</option>
                                <option value="17">17시</option>
                                <option value="18">18시</option>
                                <option value="19" selected>19시</option>
                                <option value="20">20시</option>
                                <option value="21">21시</option>
                                <option value="22">22시</option>
                                <option value="23">23시</option>
                            </select>
                        </div>
                        <div class="column">
                            <select name="minute" id="minute" class="ui fluid dropdown" required>
                                <option value="00" selected>00분</option>
                                <option value="05">05분</option>
                                <option value="10">10분</option>
                                <option value="15">15분</option>
                                <option value="20">20분</option>
                                <option value="25">25분</option>
                                <option value="30">30분</option>
                                <option value="35">35분</option>
                                <option value="40">40분</option>
                                <option value="45">45분</option>
                                <option value="50">50분</option>
                                <option value="55">55분</option>
                            </select>
                        </div>
                    </div>
                    <label>비밀번호</label>
                    <input type="password" name="password" id="password" required>
                    <br>
                    <div class="ui column centered grid">
                        <button class="ui orange button" style="margin-top: 30px;"
                            onclick="return nextBtn();">다음</button>
                    </div>
                    <!-- <label>전화번호</label>
                    <input type="text" name="" id=""><br> -->
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="/Layouts/footer.jsp"></jsp:include>
</body>

<script>
    // 다음지도 API START
    var markers = [];

    var mapContainer = document.getElementById('map'),
        mapOption = {
            center: new daum.maps.LatLng(37.546553077962855, 126.67687797686735),
            level: 3
        };

    var map = new daum.maps.Map(mapContainer, mapOption);
    var ps = new daum.maps.services.Places();
    var infowindow = new daum.maps.InfoWindow({
        zIndex: 1
    });

    searchPlaces();

    function searchPlaces() {
        var keyword = document.getElementById('keyword').value;

        if (!keyword.replace(/^\s+|\s+$/g, '')) {
            alert('키워드를 입력해주세요!');
            return false;
        }

        ps.keywordSearch(keyword, placesSearchCB);
    }

    function placesSearchCB(data, status, pagination) {
        if (status === daum.maps.services.Status.OK) {

            displayPlaces(data);

            displayPagination(pagination);

        } else if (status === daum.maps.services.Status.ZERO_RESULT) {
            alert('검색 결과가 존재하지 않습니다.');
            return;

        } else if (status === daum.maps.services.Status.ERROR) {
            alert('검색 결과 중 오류가 발생했습니다.');
            return;

        }
    }

    function displayPlaces(places) {

        var listEl = document.getElementById('placesList'),
            menuEl = document
            .getElementById('menu_wrap'),
            fragment = document
            .createDocumentFragment(),
            bounds = new daum.maps.LatLngBounds(),
            listStr = '';

        removeAllChildNods(listEl);

        removeMarker();

        for (var i = 0; i < places.length; i++) {

            var placePosition = new daum.maps.LatLng(places[i].y, places[i].x),
                marker = addMarker(
                    placePosition, i),
                itemEl = getListItem(i, places[i]);

            bounds.extend(placePosition);

            (function (marker, title) {
                daum.maps.event.addListener(marker, 'mouseover', function () {
                    displayInfowindow(marker, title);
                });

                daum.maps.event.addListener(marker, 'mouseout', function () {
                    infowindow.close();
                });

                itemEl.onmouseover = function () {
                    displayInfowindow(marker, title);
                };

                itemEl.onmouseout = function () {
                    infowindow.close();
                };
            })(marker, places[i].place_name);

            fragment.appendChild(itemEl);
        }

        listEl.appendChild(fragment);
        menuEl.scrollTop = 0;

        map.setBounds(bounds);
    }

    function getListItem(index, places) {

        var el = document.createElement('li'),
            itemStr = '<div id="valueSelector" onclick="selectAddr(this);">' +
            '<span class="markerbg marker_' +
            (index + 1) +
            '"></span>' +
            '<div class="info">' +
            '  <h5 id="placeName">' +
            places.place_name + '</h5>';

        if (places.road_address_name) {
            itemStr += '    <span id="placeRoadAddr">' +
                places.road_address_name + '</span>' +
                '   <span class="jibun gray">' + places.address_name +
                '</span>';
        } else {
            itemStr += '    <span>' + places.address_name + '</span>';
        }

        itemStr += '  <span class="tel">' + places.phone + '</span>' +
            '</div></div>';

        el.innerHTML = itemStr;
        el.className = 'item';

        return el;
    }

    function addMarker(position, idx, title) {
        var imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png',
            imageSize = new daum.maps.Size(
                36, 37),
            imgOptions = {
                spriteSize: new daum.maps.Size(36, 691),
                spriteOrigin: new daum.maps.Point(0, (idx * 46) + 10),
                offset: new daum.maps.Point(13, 37)
            },
            markerImage = new daum.maps.MarkerImage(imageSrc, imageSize,
                imgOptions),
            marker = new daum.maps.Marker({
                position: position,
                image: markerImage
            });

        marker.setMap(map);
        markers.push(marker);

        return marker;
    }

    function removeMarker() {
        for (var i = 0; i < markers.length; i++) {
            markers[i].setMap(null);
        }
        markers = [];
    }

    function displayPagination(pagination) {
        var paginationEl = document.getElementById('pagination'),
            fragment = document
            .createDocumentFragment(),
            i;

        while (paginationEl.hasChildNodes()) {
            paginationEl.removeChild(paginationEl.lastChild);
        }

        for (i = 1; i <= pagination.last; i++) {
            var el = document.createElement('a');
            el.href = "#";
            el.innerHTML = i;

            if (i === pagination.current) {
                el.className = 'on';
            } else {
                el.onclick = (function (i) {
                    return function () {
                        pagination.gotoPage(i);
                    }
                })(i);
            }

            fragment.appendChild(el);
        }
        paginationEl.appendChild(fragment);
    }

    function displayInfowindow(marker, title) {
        var content = '<div style="padding:5px;z-index:1;">' + title + '</div>';

        infowindow.setContent(content);
        infowindow.open(map, marker);
    }

    function removeAllChildNods(el) {
        while (el.hasChildNodes()) {
            el.removeChild(el.lastChild);
        }
    }
    // 다음지도 API END

    // 장소선택
    function selectAddr(val) {
        const h5 = val.getElementsByTagName("h5");
        const span = val.getElementsByTagName("span");

        let h5Val, spanVal;
        for (let i = 0; i < h5.length; i++) {
            h5Val = h5.item(i);
            $("#location").val(h5Val.innerHTML);
        }

        for (var i = 0; i < 2; i++) {
            spanVal = span.item(i);
            $("#address").val(spanVal.innerHTML);
        }
        $('html, body').scrollTop(document.body.scrollHeight);
    }

    function nextBtn() {
        if ($("#location").val() == "" && $("#address").val() == "") {
            alert('장소를 선택하세요');
            return false;
        }

        if ($("#password").val() == "") {
            alert('비밀번호를 입력하세요');
            return false;
        }

        //else {
        //    alert('준비중');
        //    return false;
        // };
    }

    // combobox
    $('.ui.dropdown').dropdown();

    // datepicker
    $(function () {
        $("#rdate").datepicker();
    });
</script>

</html>