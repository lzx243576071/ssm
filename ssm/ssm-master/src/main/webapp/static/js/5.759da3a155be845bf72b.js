webpackJsonp([5],{KR8f:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var i=a("woOf"),n=a.n(i),o=a("2Wsv");var s=a("bUZw"),l={data:function(){return{slideList:[],itemClassifyList:[],evaluationList:[],XSQGItemList:[]}},computed:{},created:function(){this._fetchHome()},methods:{_onSearch:function(){this.$router.push({path:"/search"})},_fetchHome:function(){var t,e=this;Object(o.a)({url:"/ssm/weChat/oneKeyOrder",method:"get",params:t}).then(function(t){console.log("-res-",t),e.evaluationList=t.appraiseList,e.XSQGItemList=t.XSQGItemList,t.XSQGItemList.forEach(function(t){e.slideList.push(n()(t,{url:"http://www.didichuxing.com/",image:"https://gd3.alicdn.com/imgextra/i3/2239643951/O1CN01ywTFBz1f3bNyfkZE9_!!2239643951.jpg_400x400.jpg"}))}),t.itemClassifyList.forEach(function(t){var a=s.a.find(function(e){return e.classifyId===t.classifyId});e.itemClassifyList.push({classifyId:t.classifyId,classifyName:t.classifyName,logo:{backgroundImage:"url("+a.logo+")"}})})}).catch(function(t){})},_openItem:function(t){this.$router.push({path:"/category-select",query:{classifyId:t.classifyId}})},clickHandler:function(t,e){console.log(t,e)}}},A={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("layout",[a("div",{staticClass:"page"},[a("cube-scroll",{ref:"scroll"},[a("div",{staticClass:"search-wrap"},[a("div",{staticClass:"search",on:{click:t._onSearch}},[a("i",{staticClass:"search-i"}),t._v(" "),a("span",{staticClass:"search-text"},[t._v("搜索")])])]),t._v(" "),a("div",{staticClass:"slide-wrap"},[a("cube-slide",{attrs:{data:t.slideList}},t._l(t.slideList,function(e,i){return a("cube-slide-item",{key:i,nativeOn:{click:function(a){t.clickHandler(e,i)}}},[a("img",{attrs:{src:e.image}})])}))],1),t._v(" "),a("div",{staticClass:"tab-wrap"},[a("ul",{staticClass:"tab-nav"},t._l(t.itemClassifyList,function(e,i){return a("li",{key:i,staticClass:"tab-link",on:{click:function(a){t._openItem(e)}}},[a("div",{staticClass:"logo",style:e.logo}),t._v(" "),a("p",{staticClass:"text"},[t._v(t._s(e.classifyName))])])}))]),t._v(" "),a("div",{staticClass:"today-sale-wrap"},[a("div",{staticClass:"today-sale"},[a("div",{staticClass:"sale-top"},[a("i",{staticClass:"logo"}),t._v(" "),a("span",{staticClass:"title"},[t._v("限时特价")]),t._v(" "),a("span",{staticClass:"time"},[t._v("10:10:10")])]),t._v(" "),a("ul",{staticClass:"sale-list"},t._l(t.XSQGItemList,function(e,i){return a("li",{key:i,staticClass:"sale-item"},[a("div",{staticClass:"product-img"},[a("img",{attrs:{src:"/picture/"+e.itemImg,alt:""}})]),t._v(" "),a("div",{staticClass:"info"},[a("div",{staticClass:"title"},[a("span",{staticClass:"name"},[t._v("夏装上衣")]),t._v(" "),a("span",{staticClass:"tip"},[t._v("纯棉")])]),t._v(" "),a("div",{staticClass:"price"},[a("span",{staticClass:"num"},[t._v("抢购价 ￥100")]),t._v(" "),a("span",{staticClass:"count"},[t._v("/件")])])]),t._v(" "),a("div",{staticClass:"btn"},[t._v("立即抢购")])])}))])]),t._v(" "),a("div",{staticClass:"user-evaluation-wrap"},[a("div",{staticClass:"user-evaluation"},[a("div",{staticClass:"evaluation-top"},[a("i",{staticClass:"logo"})]),t._v(" "),a("ul",{staticClass:"evaluation-list"},t._l(t.evaluationList,function(e,i){return a("li",{key:i,staticClass:"evaluation-item"},[a("div",{staticClass:"evaluation"},[a("div",{staticClass:"user"},[a("div",{staticClass:"avatar"},[a("img",{attrs:{src:"https://gd3.alicdn.com/imgextra/i3/2239643951/O1CN01ywTFBz1f3bNyfkZE9_!!2239643951.jpg_400x400.jpg",alt:""}})]),t._v(" "),a("div",{staticClass:"info"},[a("div",{staticClass:"name"},[t._v("\n                        "+t._s(e.userName)+" "),a("span",{staticClass:"tip"},[t._v(t._s(e.classifyName))])]),t._v(" "),a("div",{staticClass:"phone"},[t._v(t._s(e.userMobile.substr(0,3))+"****"+t._s(e.userMobile.substr(7)))])])]),t._v(" "),a("div",{staticClass:"comment"},[t._v(t._s(e.appraiseContent))])]),t._v(" "),a("div",{staticClass:"time"},[t._v(t._s(e.appraiseTime))])])}))])])])],1)])},staticRenderFns:[]};var r=a("VU/8")(l,A,!1,function(t){a("oVMf")},null,null);e.default=r.exports},"OPu/":function(t,e){t.exports="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAH4AAAAgCAYAAADUp8wPAAAGVUlEQVR4Xu1bTVLbSBT+ngLMbMkRoFIxYdiMvZxNPMMR8BHgCAgOAPYR8BHiI8SYzexizYYYnJqKjzDeToWgN9WSbEvq1+qWbWIY0NLqH3V/733v14SX51neAD3LUxccmv2dP/KvqXnbLbonaQ6wFlDzerzM+032qeprcpeaw6DMXiLw9eq7AxB9KLOQNpYw/vavt/3ntf3w9druVwBbC+1nnzzq9QfbtmF8UukDyFwunQ8LFYRPKqyty6iVBcP6bac7H8B8oO9FPjVvW7b56ffigd7XfvlIYE3yyywcjWX4vWBg/aB6bVe/uNKb2Sf0+gPtvOzvbQJ3kdApoJ4t8O9/3auSFyqpzz6EMRib9uvNjHDSstUCXzkE4SIW1PXXoLuPRRrPp2+bgsYd6/dFHSAcZX4PN1oS/fNJRe25iKIpk2LDZkTnwynjaRrwe233goFDHXdv+7J/nT1IapDRPDA3esFNp0hgCoC3soVhXR0IALLG7xyDOAJTUbpN40Vad9UGA/1Le7ouWWZc2mRlgP9tb29z4+fwq6bZRJ3ep88N2yayreag17+pzQO8BJTtG9R7kyDZgAdRBxyZuKz2qN+VYJzdNv6XwNeru8cgaFRGCPcv+8WebXThc84vA9SDAm9ZPGEERct5WhU8bSh2zHr1fN+g5t8aa8pRgfAxMTPpexHaCGPhLHrS0UlG4100VrFCfvGJ5z4vY6wUeGWzmUTToJk7g3c/r1cfOZaxT+H6KCdUsuW6kMkrjul8uB+x1+S9yUYz+Oiqf9NW40yOX5pC5/ERngjwGecofa8LAv+PK+rLGDex81Sv7U6oXcWH2ViaMO59GryebOgCvGkMg7oEDhg8mgjSVOgM4dwPsfEzjQ/ofFgrcu7Y35GZgVj9nvMLuIXQExI4s2RLovErA74ohm71+gO/DPARMxTlAQRHcVUaz36lCsIkdO0qGjQBvzSQOJtsMQrTourtoSole9IabwSekA3hXDQ+dvIKMn+PFXiiTuK1i5m7hwJe3Ve0tvc9ziVknnBEZ1+miheNNfskkeBOpkcClYSp6SXTwIvpUgLal/3BUXqSK/AR+KY07LMHHkfUHEY+U8ZP8FOJpOyrmePG9w143qHBGY1MlTPwZRilDPBl1l1VAof9N1ugV3FNgrirtMuWwHE517xFmwJtjrdl1ODxwVKBT2Lw4rQf0ZZYJACsGTZC2DXlAlaZstU0Ty/SqFS1Dw9VOhtmGNAkBLKXT/u2Kl9M+zvH8EIZh3CjBe/bsRvwIoNMI5NZOFd71wdISkS4CLl9TEHB5pEDPzlbAEYbIFtOXLGH4OVHSZYR8L2TT+Kw/1ZVQ5WNz0UGaOeFrYAVMlRvA+QF+LytFcqyyRBV715cMVjW/AJAZwWYElTvDPzSSrGmKt4cGv8j4viYXt9sAWsHIFbFKVNfwIMCH3vshnr71GNzt/HOwNsGur6vSyaDMCb2aqbq3qrieKfLjh2/FsKwDXql0qvzNozEmmvQ+JQ3XlCeXQtcbbwNr6W2XhXE75lEUP6jVgW8a2xu68ARHEShI0eneDaHcDbc5n9P3FLRy3KBl2N3azPGUwI+SYxk2594fT/dYOHq1ZuSLPOj6jBz2cCbSrJYoBHjoW18TuO7YGol2S5jz10UoxNnK2o5+n42wJvKsaowc9X/PE0jmuRxpRrv3TURoj1pjHRJ4PBJRRVW0qFXbL8TbXIHPnIqLT5DuAmKysZFEUUAntTjVbuXVByaehFjddalUL2pFMuhV7v669ra9rsq4CVBdAL+tHIB1tvTygJvI+akiKTi+zJhZICc6ZH2WRh4UxpXyvU/No2fG3iJ7hPvP0n7Ojl3RcBb7X/cJqa3WseLBjB0+0z2tAIf0fhPYUGHiupRy2X8SvTUqw9ZVa5+XuBnoVelCpAefkmZOyGMS/IHOtXH801h3QiMRtQKHmf8TP9/GIHZ12mf3aje2G5dIK7prh0bnVmAd5nuPMbFWXSh+lTMLZY+xQ8SgZdLp8YDRb11634mgoh7ChT4bvkFV6++PPD2rlrXON4ZUceBTxj4MZiPqPlFbKhMohMFvr03/6GAd+3ITWP1yP5Clf9zg7nXrkwCRtR4Yw0+fT1d8P2R1J2bl3c2OZ3pga7AOyrTy7AndgNW5+6Jneflcx1v4D+peoVdgu5LPwAAAABJRU5ErkJggg=="},oVMf:function(t,e,a){var i=a("txwt");"string"==typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);a("rjj0")("33a0cde7",i,!0,null)},oxsw:function(t,e){t.exports="data:image/png;base64,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"},txwt:function(t,e,a){var i=a("kxFB");(t.exports=a("FZ+f")(!0)).push([t.i,'\n.page{font-family:HiraginoSansGB-W3;height:calc(100vh - 13.067vw);content:"viewport-units-buggyfill; height: calc(100vh - 13.067vw)"\n}\n.page .search-wrap{background-color:#fff;padding:1.6vw 0 2.133vw;content:"viewport-units-buggyfill; padding: 1.6vw 0 2.133vw 0"\n}\n.page .search-wrap .search{margin:0 auto;width:93.333vw;height:8vw;line-height:8vw;background:#f2f2f2;border-radius:4vw;text-align:center;content:"viewport-units-buggyfill; width: 93.333vw; height: 8vw; line-height: 8vw; border-radius: 4vw"\n}\n.page .search-wrap .search .search-i{vertical-align:middle;display:inline-block;width:4.267vw;height:4.267vw;background-image:url('+i(a("6/w1"))+');background-size:100% 100%;background-repeat:no-repeat;content:"viewport-units-buggyfill; width: 4.267vw; height: 4.267vw"\n}\n.page .search-wrap .search .search-text{display:inline-block;font-size:3.2vw;color:#666;content:"viewport-units-buggyfill; font-size: 3.2vw"\n}\n.page .slide-wrap,.page .slide-wrap img{height:32vw;content:"viewport-units-buggyfill; height: 32vw"\n}\n.page .tab-wrap{background-color:#fff;min-height:48vw;content:"viewport-units-buggyfill; min-height: 48vw"\n}\n.page .tab-wrap .tab-nav{display:-webkit-box;display:-ms-flexbox;display:flex;-ms-flex-wrap:wrap;flex-wrap:wrap;-webkit-box-pack:center;-ms-flex-pack:center;justify-content:center;-webkit-box-align:center;-ms-flex-align:center;align-items:center;padding-bottom:5.067vw;content:"viewport-units-buggyfill; padding-bottom: 5.067vw"\n}\n.page .tab-wrap .tab-nav .tab-link{width:33.333vw;text-align:center;padding-top:5.067vw;content:"viewport-units-buggyfill; width: 33.333vw; padding-top: 5.067vw"\n}\n.page .tab-wrap .tab-nav .tab-link .logo{margin:0 auto;width:10.667vw;height:10.667vw;background-size:100% 100%;background-repeat:no-repeat;content:"viewport-units-buggyfill; width: 10.667vw; height: 10.667vw"\n}\n.page .tab-wrap .tab-nav .tab-link .text{margin-top:2.4vw;font-size:3.2vw;color:#666;content:"viewport-units-buggyfill; margin-top: 2.4vw; font-size: 3.2vw"\n}\n.page .today-sale-wrap{margin-top:2.533vw;background-color:#fff;content:"viewport-units-buggyfill; margin-top: 2.533vw"\n}\n.page .today-sale-wrap .today-sale .sale-top{position:relative;height:13.333vw;line-height:13.333vw;text-align:right;padding:0 3.867vw;font-size:3.2vw;color:#333;content:"viewport-units-buggyfill; height: 13.333vw; line-height: 13.333vw; padding: 0 3.867vw; font-size: 3.2vw"\n}\n.page .today-sale-wrap .today-sale .sale-top .logo{position:absolute;top:4.533vw;left:3.867vw;display:inline-block;width:16.8vw;height:4.267vw;background-image:url('+i(a("OPu/"))+');background-size:100% 100%;background-repeat:no-repeat;content:"viewport-units-buggyfill; top: 4.533vw; left: 3.867vw; width: 16.8vw; height: 4.267vw"\n}\n.page .today-sale-wrap .today-sale .sale-top .title{color:#333\n}\n.page .today-sale-wrap .today-sale .sale-top .time{color:#f43030\n}\n.page .today-sale-wrap .today-sale .sale-list{padding:0 4vw;content:"viewport-units-buggyfill; padding: 0 4vw"\n}\n.page .today-sale-wrap .today-sale .sale-list .sale-item{padding:2.667vw 0;display:-webkit-box;display:-ms-flexbox;display:flex;border-bottom:.5px solid #f2f2f2;content:"viewport-units-buggyfill; padding: 2.667vw 0"\n}\n.page .today-sale-wrap .today-sale .sale-list .sale-item .product-img,.page .today-sale-wrap .today-sale .sale-list .sale-item .product-img img{width:24vw;height:16vw;border-radius:1.067vw;content:"viewport-units-buggyfill; width: 24vw; height: 16vw; border-radius: 1.067vw"\n}\n.page .today-sale-wrap .today-sale .sale-list .sale-item .info{-webkit-box-flex:1;-ms-flex:1;flex:1;padding-left:2.8vw;content:"viewport-units-buggyfill; padding-left: 2.8vw"\n}\n.page .today-sale-wrap .today-sale .sale-list .sale-item .info .title{margin-top:1.333vw;content:"viewport-units-buggyfill; margin-top: 1.333vw"\n}\n.page .today-sale-wrap .today-sale .sale-list .sale-item .info .title .name{font-size:3.733vw;color:#333;content:"viewport-units-buggyfill; font-size: 3.733vw"\n}\n.page .today-sale-wrap .today-sale .sale-list .sale-item .info .title .tip{vertical-align:middle;padding:.267vw .8vw;font-size:2.4vw;background:#f89771;border-radius:1.067vw;color:#fff;content:"viewport-units-buggyfill; padding: 0.267vw 0.8vw; font-size: 2.4vw; border-radius: 1.067vw"\n}\n.page .today-sale-wrap .today-sale .sale-list .sale-item .info .price{margin-top:4.667vw;content:"viewport-units-buggyfill; margin-top: 4.667vw"\n}\n.page .today-sale-wrap .today-sale .sale-list .sale-item .info .price .num{font-size:3.2vw;color:#f43030;content:"viewport-units-buggyfill; font-size: 3.2vw"\n}\n.page .today-sale-wrap .today-sale .sale-list .sale-item .info .price .count{font-size:2.667vw;color:#666;content:"viewport-units-buggyfill; font-size: 2.667vw"\n}\n.page .today-sale-wrap .today-sale .sale-list .sale-item .btn{margin-top:4.8vw;width:16vw;height:6.4vw;line-height:6.4vw;background:#ff8c45;border-radius:.533vw;font-size:2.667vw;color:#fff;text-align:center;content:"viewport-units-buggyfill; margin-top: 4.8vw; width: 16vw; height: 6.4vw; line-height: 6.4vw; border-radius: 0.533vw; font-size: 2.667vw"\n}\n.page .user-evaluation-wrap{margin-top:2.533vw;background-color:#fff;content:"viewport-units-buggyfill; margin-top: 2.533vw"\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-top{position:relative;width:100%;height:13.333vw;content:"viewport-units-buggyfill; height: 13.333vw"\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-top .logo{position:absolute;top:4.533vw;left:3.867vw;display:inline-block;width:16.8vw;height:4.267vw;background-image:url('+i(a("oxsw"))+');background-size:100% 100%;background-repeat:no-repeat;content:"viewport-units-buggyfill; top: 4.533vw; left: 3.867vw; width: 16.8vw; height: 4.267vw"\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-list{padding:0 4vw;content:"viewport-units-buggyfill; padding: 0 4vw"\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-list .evaluation-item{padding:2.667vw 0;display:-webkit-box;display:-ms-flexbox;display:flex;border-bottom:.5px solid #f2f2f2;content:"viewport-units-buggyfill; padding: 2.667vw 0"\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-list .evaluation-item .evaluation{-webkit-box-flex:1;-ms-flex:1;flex:1\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-list .evaluation-item .evaluation .user{display:-webkit-box;display:-ms-flexbox;display:flex\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-list .evaluation-item .evaluation .user .avatar,.page .user-evaluation-wrap .user-evaluation .evaluation-list .evaluation-item .evaluation .user .avatar img{width:8vw;height:8vw;border-radius:50%;content:"viewport-units-buggyfill; width: 8vw; height: 8vw"\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-list .evaluation-item .evaluation .user .info{-webkit-box-flex:1;-ms-flex:1;flex:1;padding-left:2.667vw;content:"viewport-units-buggyfill; padding-left: 2.667vw"\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-list .evaluation-item .evaluation .user .info .name{font-size:3.2vw;color:#333;content:"viewport-units-buggyfill; font-size: 3.2vw"\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-list .evaluation-item .evaluation .user .info .name .tip{padding-left:4.133vw;color:#ff8c45;font-size:3.2vw;content:"viewport-units-buggyfill; padding-left: 4.133vw; font-size: 3.2vw"\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-list .evaluation-item .evaluation .user .info .phone{margin-top:1.733vw;color:#666;font-size:2.667vw;content:"viewport-units-buggyfill; margin-top: 1.733vw; font-size: 2.667vw"\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-list .evaluation-item .evaluation .comment{padding-top:4vw;font-size:3.2vw;color:#333;content:"viewport-units-buggyfill; padding-top: 4vw; font-size: 3.2vw"\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-list .evaluation-item .time{width:18.8vw;font-size:3.2vw;color:#999;content:"viewport-units-buggyfill; width: 18.8vw; font-size: 3.2vw"\n}\n.cube-pulldown-wrapper{-webkit-transform:translateY(-100%);transform:translateY(-100%);line-height:0\n}\n.cube-pulldown-wrapper .pulldown-content{width:100%\n}\n.cube-pulldown-wrapper .pulldown-content span{position:absolute;bottom:2.666vw;left:0;right:0;margin:auto;width:53.334vw;line-height:5.334vw;text-align:center;color:#000;font-size:3.2vw;content:"viewport-units-buggyfill; bottom: 2.666vw; width: 53.334vw; line-height: 5.334vw; font-size: 3.2vw"\n}\n.surprise-page{position:absolute;top:0;bottom:0;right:0;left:0;z-index:33;line-height:0\n}\n.surprise-page img{height:100%;width:100%\n}\n.surprise-page .surprise-page-enter,.surprise-page .surprise-page-leave-to{-webkit-transform:translateY(-100%);transform:translateY(-100%)\n}\n.surprise-page .surprise-page-enter-active,.surprise-page .surprise-page-leave-active{-webkit-transition:-webkit-transform .3s;transition:-webkit-transform .3s;transition:transform .3s;transition:transform .3s,-webkit-transform .3s\n}',"",{version:3,sources:["G:/project/mall/src/views/home/index.vue"],names:[],mappings:"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",file:"index.vue",sourcesContent:['\n.page{font-family:HiraginoSansGB-W3;height:calc(100vh - 13.067vw);content:"viewport-units-buggyfill; height: calc(100vh - 13.067vw)"\n}\n.page .search-wrap{background-color:#fff;padding:1.6vw 0 2.133vw;content:"viewport-units-buggyfill; padding: 1.6vw 0 2.133vw 0"\n}\n.page .search-wrap .search{margin:0 auto;width:93.333vw;height:8vw;line-height:8vw;background:#f2f2f2;border-radius:4vw;text-align:center;content:"viewport-units-buggyfill; width: 93.333vw; height: 8vw; line-height: 8vw; border-radius: 4vw"\n}\n.page .search-wrap .search .search-i{vertical-align:middle;display:inline-block;width:4.267vw;height:4.267vw;background-image:url(../../../static/image/common/icon_search@2x.png);background-size:100% 100%;background-repeat:no-repeat;content:"viewport-units-buggyfill; width: 4.267vw; height: 4.267vw"\n}\n.page .search-wrap .search .search-text{display:inline-block;font-size:3.2vw;color:#666;content:"viewport-units-buggyfill; font-size: 3.2vw"\n}\n.page .slide-wrap,.page .slide-wrap img{height:32vw;content:"viewport-units-buggyfill; height: 32vw"\n}\n.page .tab-wrap{background-color:#fff;min-height:48vw;content:"viewport-units-buggyfill; min-height: 48vw"\n}\n.page .tab-wrap .tab-nav{display:-webkit-box;display:-ms-flexbox;display:flex;-ms-flex-wrap:wrap;flex-wrap:wrap;-webkit-box-pack:center;-ms-flex-pack:center;justify-content:center;-webkit-box-align:center;-ms-flex-align:center;align-items:center;padding-bottom:5.067vw;content:"viewport-units-buggyfill; padding-bottom: 5.067vw"\n}\n.page .tab-wrap .tab-nav .tab-link{width:33.333vw;text-align:center;padding-top:5.067vw;content:"viewport-units-buggyfill; width: 33.333vw; padding-top: 5.067vw"\n}\n.page .tab-wrap .tab-nav .tab-link .logo{margin:0 auto;width:10.667vw;height:10.667vw;background-size:100% 100%;background-repeat:no-repeat;content:"viewport-units-buggyfill; width: 10.667vw; height: 10.667vw"\n}\n.page .tab-wrap .tab-nav .tab-link .text{margin-top:2.4vw;font-size:3.2vw;color:#666;content:"viewport-units-buggyfill; margin-top: 2.4vw; font-size: 3.2vw"\n}\n.page .today-sale-wrap{margin-top:2.533vw;background-color:#fff;content:"viewport-units-buggyfill; margin-top: 2.533vw"\n}\n.page .today-sale-wrap .today-sale .sale-top{position:relative;height:13.333vw;line-height:13.333vw;text-align:right;padding:0 3.867vw;font-size:3.2vw;color:#333;content:"viewport-units-buggyfill; height: 13.333vw; line-height: 13.333vw; padding: 0 3.867vw; font-size: 3.2vw"\n}\n.page .today-sale-wrap .today-sale .sale-top .logo{position:absolute;top:4.533vw;left:3.867vw;display:inline-block;width:16.8vw;height:4.267vw;background-image:url(../../../static/image/home/text_jrtm@2x.png);background-size:100% 100%;background-repeat:no-repeat;content:"viewport-units-buggyfill; top: 4.533vw; left: 3.867vw; width: 16.8vw; height: 4.267vw"\n}\n.page .today-sale-wrap .today-sale .sale-top .title{color:#333\n}\n.page .today-sale-wrap .today-sale .sale-top .time{color:#f43030\n}\n.page .today-sale-wrap .today-sale .sale-list{padding:0 4vw;content:"viewport-units-buggyfill; padding: 0 4vw"\n}\n.page .today-sale-wrap .today-sale .sale-list .sale-item{padding:2.667vw 0;display:-webkit-box;display:-ms-flexbox;display:flex;border-bottom:.5px solid #f2f2f2;content:"viewport-units-buggyfill; padding: 2.667vw 0"\n}\n.page .today-sale-wrap .today-sale .sale-list .sale-item .product-img,.page .today-sale-wrap .today-sale .sale-list .sale-item .product-img img{width:24vw;height:16vw;border-radius:1.067vw;content:"viewport-units-buggyfill; width: 24vw; height: 16vw; border-radius: 1.067vw"\n}\n.page .today-sale-wrap .today-sale .sale-list .sale-item .info{-webkit-box-flex:1;-ms-flex:1;flex:1;padding-left:2.8vw;content:"viewport-units-buggyfill; padding-left: 2.8vw"\n}\n.page .today-sale-wrap .today-sale .sale-list .sale-item .info .title{margin-top:1.333vw;content:"viewport-units-buggyfill; margin-top: 1.333vw"\n}\n.page .today-sale-wrap .today-sale .sale-list .sale-item .info .title .name{font-size:3.733vw;color:#333;content:"viewport-units-buggyfill; font-size: 3.733vw"\n}\n.page .today-sale-wrap .today-sale .sale-list .sale-item .info .title .tip{vertical-align:middle;padding:.267vw .8vw;font-size:2.4vw;background:#f89771;border-radius:1.067vw;color:#fff;content:"viewport-units-buggyfill; padding: 0.267vw 0.8vw; font-size: 2.4vw; border-radius: 1.067vw"\n}\n.page .today-sale-wrap .today-sale .sale-list .sale-item .info .price{margin-top:4.667vw;content:"viewport-units-buggyfill; margin-top: 4.667vw"\n}\n.page .today-sale-wrap .today-sale .sale-list .sale-item .info .price .num{font-size:3.2vw;color:#f43030;content:"viewport-units-buggyfill; font-size: 3.2vw"\n}\n.page .today-sale-wrap .today-sale .sale-list .sale-item .info .price .count{font-size:2.667vw;color:#666;content:"viewport-units-buggyfill; font-size: 2.667vw"\n}\n.page .today-sale-wrap .today-sale .sale-list .sale-item .btn{margin-top:4.8vw;width:16vw;height:6.4vw;line-height:6.4vw;background:#ff8c45;border-radius:.533vw;font-size:2.667vw;color:#fff;text-align:center;content:"viewport-units-buggyfill; margin-top: 4.8vw; width: 16vw; height: 6.4vw; line-height: 6.4vw; border-radius: 0.533vw; font-size: 2.667vw"\n}\n.page .user-evaluation-wrap{margin-top:2.533vw;background-color:#fff;content:"viewport-units-buggyfill; margin-top: 2.533vw"\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-top{position:relative;width:100%;height:13.333vw;content:"viewport-units-buggyfill; height: 13.333vw"\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-top .logo{position:absolute;top:4.533vw;left:3.867vw;display:inline-block;width:16.8vw;height:4.267vw;background-image:url(../../../static/image/home/text_yhpj@2x.png);background-size:100% 100%;background-repeat:no-repeat;content:"viewport-units-buggyfill; top: 4.533vw; left: 3.867vw; width: 16.8vw; height: 4.267vw"\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-list{padding:0 4vw;content:"viewport-units-buggyfill; padding: 0 4vw"\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-list .evaluation-item{padding:2.667vw 0;display:-webkit-box;display:-ms-flexbox;display:flex;border-bottom:.5px solid #f2f2f2;content:"viewport-units-buggyfill; padding: 2.667vw 0"\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-list .evaluation-item .evaluation{-webkit-box-flex:1;-ms-flex:1;flex:1\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-list .evaluation-item .evaluation .user{display:-webkit-box;display:-ms-flexbox;display:flex\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-list .evaluation-item .evaluation .user .avatar,.page .user-evaluation-wrap .user-evaluation .evaluation-list .evaluation-item .evaluation .user .avatar img{width:8vw;height:8vw;border-radius:50%;content:"viewport-units-buggyfill; width: 8vw; height: 8vw"\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-list .evaluation-item .evaluation .user .info{-webkit-box-flex:1;-ms-flex:1;flex:1;padding-left:2.667vw;content:"viewport-units-buggyfill; padding-left: 2.667vw"\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-list .evaluation-item .evaluation .user .info .name{font-size:3.2vw;color:#333;content:"viewport-units-buggyfill; font-size: 3.2vw"\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-list .evaluation-item .evaluation .user .info .name .tip{padding-left:4.133vw;color:#ff8c45;font-size:3.2vw;content:"viewport-units-buggyfill; padding-left: 4.133vw; font-size: 3.2vw"\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-list .evaluation-item .evaluation .user .info .phone{margin-top:1.733vw;color:#666;font-size:2.667vw;content:"viewport-units-buggyfill; margin-top: 1.733vw; font-size: 2.667vw"\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-list .evaluation-item .evaluation .comment{padding-top:4vw;font-size:3.2vw;color:#333;content:"viewport-units-buggyfill; padding-top: 4vw; font-size: 3.2vw"\n}\n.page .user-evaluation-wrap .user-evaluation .evaluation-list .evaluation-item .time{width:18.8vw;font-size:3.2vw;color:#999;content:"viewport-units-buggyfill; width: 18.8vw; font-size: 3.2vw"\n}\n.cube-pulldown-wrapper{-webkit-transform:translateY(-100%);transform:translateY(-100%);line-height:0\n}\n.cube-pulldown-wrapper .pulldown-content{width:100%\n}\n.cube-pulldown-wrapper .pulldown-content span{position:absolute;bottom:2.666vw;left:0;right:0;margin:auto;width:53.334vw;line-height:5.334vw;text-align:center;color:#000;font-size:3.2vw;content:"viewport-units-buggyfill; bottom: 2.666vw; width: 53.334vw; line-height: 5.334vw; font-size: 3.2vw"\n}\n.surprise-page{position:absolute;top:0;bottom:0;right:0;left:0;z-index:33;line-height:0\n}\n.surprise-page img{height:100%;width:100%\n}\n.surprise-page .surprise-page-enter,.surprise-page .surprise-page-leave-to{-webkit-transform:translateY(-100%);transform:translateY(-100%)\n}\n.surprise-page .surprise-page-enter-active,.surprise-page .surprise-page-leave-active{-webkit-transition:-webkit-transform .3s;transition:-webkit-transform .3s;transition:transform .3s;transition:transform .3s,-webkit-transform .3s\n}'],sourceRoot:""}])}});
//# sourceMappingURL=5.759da3a155be845bf72b.js.map