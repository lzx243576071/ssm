webpackJsonp([10],{LOEv:function(t,e,i){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var s=i("NS8l"),a={name:"my-address",data:function(){return{data:[]}},created:function(){this._queryReceiveArea()},methods:{_queryReceiveArea:function(){var t=this;Object(s.e)({userId:1}).then(function(e){e.forEach(function(e){t.data.push({item:e,btns:[{action:"clear",text:"设为默认",color:"#c8c7cd"},{action:"delete",text:"删除",color:"#ff3a32"}]})})})},onBtnClick:function(t,e){var i=this;"delete"===t.action?this.$createActionSheet({title:"确认要删除吗",active:0,data:[{content:"删除"}],onSelect:function(){i._onDel(i.data[e].item)}}).show():this.$refs.swipeItem[e].shrink(),"clear"===t.action?this.$createActionSheet({title:"确认要设置默认吗",active:0,data:[{content:"设置"}],onSelect:function(){i._onSelect(i.data[e].item)}}).show():this.$refs.swipeItem[e].shrink()},_onSelect:function(t){var e=t;delete e.gmtCreate,delete e.gmtModify,e.hasDefault=1,Object(s.g)(e).then(function(t){location.reload()})},_onDel:function(t){var e=this;if(1===t.hasDefault)return this.toast=this.$createToast({txt:"无法删除默认地址",type:"txt"}),void this.toast.show();var i={id:t.id};Object(s.b)(i).then(function(t){e.toast=e.$createToast({txt:"操作成功",type:"txt",time:500,onTimeout:function(){location.reload()}}),e.toast.show()})},_edit:function(t){this.$router.push({path:"/address-edit",query:{id:t.id}})},_add:function(){this.$router.push({path:"/address-edit"})}}},n={render:function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"my-address"},[i("div",{staticClass:"address-list"},[i("cube-scroll",[i("cube-swipe",[i("transition-group",{staticClass:"list-wrapper",attrs:{name:"swipe",tag:"ul"}},t._l(t.data,function(e,s){return i("li",{key:s,staticClass:"list-item-wrap"},[i("cube-swipe-item",{ref:"swipeItem",refInFor:!0,staticClass:"list-item",attrs:{btns:e.btns,index:s},on:{"btn-click":t.onBtnClick}},[i("div",{staticClass:"info"},[i("div",{staticClass:"name"},[t._v(t._s(e.item.receiverName))]),t._v(" "),i("div",{staticClass:"mobile"},[t._v(t._s(e.item.phone))])]),t._v(" "),i("div",{staticClass:"desc"},[i("div",{staticClass:"address"},[1===e.item.hasDefault?i("span",{staticClass:"default"},[t._v("默认")]):t._e(),t._v("\n                            "+t._s(e.item.province)+"\n                            "+t._s(e.item.city)+"\n                            "+t._s(e.item.area)+"\n                            "+t._s(e.item.address)+"\n                        ")]),t._v(" "),i("div",{staticClass:"edit",on:{click:function(i){t._edit(e.item)}}},[t._v("编辑")])])])],1)}))],1)],1)],1),t._v(" "),i("div",{staticClass:"address-add"},[i("div",{staticClass:"btn",on:{click:function(e){t._add()}}},[t._v("新增地址")])])])},staticRenderFns:[]};var r=i("VU/8")(a,n,!1,function(t){i("qmDN")},"data-v-a840fecc",null);e.default=r.exports},g6O6:function(t,e,i){(t.exports=i("FZ+f")(!0)).push([t.i,'\n.my-address[data-v-a840fecc]{height:100vh;font-family:HiraginoSansGB-W3;background-color:#fff;content:"viewport-units-buggyfill; height: 100vh"\n}\n.my-address .address-list[data-v-a840fecc]{height:calc(100vh - 16vw);content:"viewport-units-buggyfill; height: calc(100vh - 16vw)"\n}\n.my-address .address-list .list-wrapper .list-item-wrap .list-item[data-v-a840fecc]{padding:3.2vw;border-bottom:.5px solid #f2f2f2;content:"viewport-units-buggyfill; padding: 3.2vw"\n}\n.my-address .address-list .list-wrapper .list-item-wrap .list-item .info[data-v-a840fecc]{display:-webkit-box;display:-ms-flexbox;display:flex;margin-bottom:1.6vw;height:4.267vw;line-height:4.267vw;content:"viewport-units-buggyfill; margin-bottom: 1.6vw; height: 4.267vw; line-height: 4.267vw"\n}\n.my-address .address-list .list-wrapper .list-item-wrap .list-item .info .name[data-v-a840fecc]{margin-right:3.2vw;content:"viewport-units-buggyfill; margin-right: 3.2vw"\n}\n.my-address .address-list .list-wrapper .list-item-wrap .list-item .info .mobile[data-v-a840fecc]{font-size:3.2vw;color:#909497;content:"viewport-units-buggyfill; font-size: 3.2vw"\n}\n.my-address .address-list .list-wrapper .list-item-wrap .list-item .desc[data-v-a840fecc]{display:-webkit-box;display:-ms-flexbox;display:flex;margin-top:3.2vw;-webkit-box-pack:justify;-ms-flex-pack:justify;justify-content:space-between;content:"viewport-units-buggyfill; margin-top: 3.2vw"\n}\n.my-address .address-list .list-wrapper .list-item-wrap .list-item .desc .address[data-v-a840fecc]{font-size:3.2vw;content:"viewport-units-buggyfill; font-size: 3.2vw"\n}\n.my-address .address-list .list-wrapper .list-item-wrap .list-item .desc .address .default[data-v-a840fecc]{padding:.267vw .667vw;background-color:#fad7a0;color:#e74c3c;border-radius:.667vw;content:"viewport-units-buggyfill; padding: 0.267vw 0.667vw; border-radius: 0.667vw"\n}\n.my-address .address-add[data-v-a840fecc]{height:16vw;content:"viewport-units-buggyfill; height: 16vw"\n}\n.my-address .address-add .btn[data-v-a840fecc]{margin:1.333vw auto;width:80vw;height:13.067vw;line-height:13.067vw;color:#fff;text-align:center;background:#4a4c59;border-radius:1.333vw;content:"viewport-units-buggyfill; margin: 1.333vw auto; width: 80vw; height: 13.067vw; line-height: 13.067vw; border-radius: 1.333vw"\n}',"",{version:3,sources:["G:/project/mall/src/views/my-address/index.vue"],names:[],mappings:";AACA,6BAA6B,aAAa,8BAA8B,sBAAsB,iDAAiD;CAC9I;AACD,2CAA2C,0BAA0B,8DAA8D;CAClI;AACD,oFAAoF,cAAc,iCAAiC,kDAAkD;CACpL;AACD,0FAA0F,oBAAoB,oBAAoB,aAAa,oBAAoB,eAAe,oBAAoB,+FAA+F;CACpS;AACD,gGAAgG,mBAAmB,uDAAuD;CACzK;AACD,kGAAkG,gBAAgB,cAAc,oDAAoD;CACnL;AACD,0FAA0F,oBAAoB,oBAAoB,aAAa,iBAAiB,yBAAyB,sBAAsB,8BAA8B,qDAAqD;CACjS;AACD,mGAAmG,gBAAgB,oDAAoD;CACtK;AACD,4GAA4G,sBAAsB,yBAAyB,cAAc,qBAAqB,oFAAoF;CACjR;AACD,0CAA0C,YAAY,gDAAgD;CACrG;AACD,+CAA+C,oBAAoB,WAAW,gBAAgB,qBAAqB,WAAW,kBAAkB,mBAAmB,sBAAsB,sIAAsI;CAC9T",file:"index.vue",sourcesContent:['\n.my-address[data-v-a840fecc]{height:100vh;font-family:HiraginoSansGB-W3;background-color:#fff;content:"viewport-units-buggyfill; height: 100vh"\n}\n.my-address .address-list[data-v-a840fecc]{height:calc(100vh - 16vw);content:"viewport-units-buggyfill; height: calc(100vh - 16vw)"\n}\n.my-address .address-list .list-wrapper .list-item-wrap .list-item[data-v-a840fecc]{padding:3.2vw;border-bottom:.5px solid #f2f2f2;content:"viewport-units-buggyfill; padding: 3.2vw"\n}\n.my-address .address-list .list-wrapper .list-item-wrap .list-item .info[data-v-a840fecc]{display:-webkit-box;display:-ms-flexbox;display:flex;margin-bottom:1.6vw;height:4.267vw;line-height:4.267vw;content:"viewport-units-buggyfill; margin-bottom: 1.6vw; height: 4.267vw; line-height: 4.267vw"\n}\n.my-address .address-list .list-wrapper .list-item-wrap .list-item .info .name[data-v-a840fecc]{margin-right:3.2vw;content:"viewport-units-buggyfill; margin-right: 3.2vw"\n}\n.my-address .address-list .list-wrapper .list-item-wrap .list-item .info .mobile[data-v-a840fecc]{font-size:3.2vw;color:#909497;content:"viewport-units-buggyfill; font-size: 3.2vw"\n}\n.my-address .address-list .list-wrapper .list-item-wrap .list-item .desc[data-v-a840fecc]{display:-webkit-box;display:-ms-flexbox;display:flex;margin-top:3.2vw;-webkit-box-pack:justify;-ms-flex-pack:justify;justify-content:space-between;content:"viewport-units-buggyfill; margin-top: 3.2vw"\n}\n.my-address .address-list .list-wrapper .list-item-wrap .list-item .desc .address[data-v-a840fecc]{font-size:3.2vw;content:"viewport-units-buggyfill; font-size: 3.2vw"\n}\n.my-address .address-list .list-wrapper .list-item-wrap .list-item .desc .address .default[data-v-a840fecc]{padding:.267vw .667vw;background-color:#fad7a0;color:#e74c3c;border-radius:.667vw;content:"viewport-units-buggyfill; padding: 0.267vw 0.667vw; border-radius: 0.667vw"\n}\n.my-address .address-add[data-v-a840fecc]{height:16vw;content:"viewport-units-buggyfill; height: 16vw"\n}\n.my-address .address-add .btn[data-v-a840fecc]{margin:1.333vw auto;width:80vw;height:13.067vw;line-height:13.067vw;color:#fff;text-align:center;background:#4a4c59;border-radius:1.333vw;content:"viewport-units-buggyfill; margin: 1.333vw auto; width: 80vw; height: 13.067vw; line-height: 13.067vw; border-radius: 1.333vw"\n}'],sourceRoot:""}])},qmDN:function(t,e,i){var s=i("g6O6");"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);i("rjj0")("52e05e70",s,!0,null)}});
//# sourceMappingURL=10.43eb2cb7f72de662bbfd.js.map