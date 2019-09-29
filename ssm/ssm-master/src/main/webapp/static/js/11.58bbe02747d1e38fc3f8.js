﻿webpackJsonp([11],{"80Bx":function(e,t,s){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var i=s("//Fk"),a=s.n(i),d=s("NS8l"),r={name:"address-edit",data:function(){return{hasDefault:!1,selectedIndex:[],data:[[],[],[]],currentAddress:{address:"",area:"",city:"",hasDefault:0,id:0,phone:"",province:"",receiverName:"",street:"",userId:1},result:[void 0,void 0,void 0,void 0],receiverNameRules:{required:!0},phoneRules:{required:!0,type:"tel"},addressRules:{required:!0},provinceRules:{required:!0}}},created:function(){this._queryAreaList(0,0),void 0!==this.$route.query.id&&this._receiverAddressDetail(this.$route.query.id)},methods:{_receiverAddressDetail:function(e){var t=this,s={id:e};Object(d.f)(s).then(function(e){t.currentAddress=e})},_queryReceiveArea:function(){var e=this;Object(d.e)({userId:1}).then(function(t){e.currentAddress=t.find(function(t){return t.id===Number(e.$route.query.id)}),e.hasDefault=1===e.currentAddress.hasDefault})},_queryAreaList:function(e,t){var s=this,i={areaCode:e};Object(d.c)(i).then(function(e){(e||[]).forEach(function(e){s.data[t].push({text:e.areaDesc,value:e.areaCode})})})},showAddressPicker:function(){this.$refs.drawer.show()},changeHandler:function(e,t,s,i,a){this._queryAreaList(t.value,e+1),this.$refs.drawer.refill(e+1,this.data[e+1])},selectHandler:function(e,t,s){this.currentAddress.province=s[0],this.currentAddress.city=s[1],this.currentAddress.area=s[2]},cancelHandler:function(){console.log("cancel")},_blur:function(){setTimeout(function(){var e=document.documentElement.scrollTop||document.body.scrollTop||0;window.scrollTo(0,Math.max(e-1,0))},100)},_save:function(){var e=this,t=this.$refs.validator0.validate(),s=this.$refs.validator1.validate(),i=this.$refs.validator2.validate(),d=this.$refs.validator3.validate();a.a.all([t,s,i,d]).then(function(){e.result.every(function(e){return e})&&(void 0!==e.$route.query.id?e._edit():e._add())})},_add:function(){var e=this;this.currentAddress.userId=1,this.hasDefault?this.currentAddress.hasDefault=1:this.currentAddress.hasDefault=0,Object(d.a)(this.currentAddress).then(function(t){e.toast=e.$createToast({txt:"操作成功",type:"txt",time:500,onTimeout:function(){e.$router.go(-1)}}),e.toast.show()})},_edit:function(){var e=this;delete this.currentAddress.gmtCreate,delete this.currentAddress.gmtModify,this.hasDefault?this.currentAddress.hasDefault=1:this.currentAddress.hasDefault=0,Object(d.g)(this.currentAddress).then(function(t){e.toast=e.$createToast({txt:"操作成功",type:"txt",time:500,onTimeout:function(){e.$router.go(-1)}}),e.toast.show()})}}},n={render:function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"address-edit"},[s("div",{staticClass:"address-list"},[s("cube-scroll",[s("ul",{staticClass:"list"},[s("li",{staticClass:"item"},[s("div",{staticClass:"text"},[e._v("收货人")]),e._v(" "),s("div",{staticClass:"content"},[s("cube-input",{model:{value:e.currentAddress.receiverName,callback:function(t){e.$set(e.currentAddress,"receiverName",t)},expression:"currentAddress.receiverName"}}),e._v(" "),s("cube-validator",{ref:"validator0",attrs:{model:e.currentAddress.receiverName,rules:e.receiverNameRules},model:{value:e.result[0],callback:function(t){e.$set(e.result,0,t)},expression:"result[0]"}})],1)]),e._v(" "),s("li",{staticClass:"item"},[s("div",{staticClass:"text"},[e._v("手机号码")]),e._v(" "),s("div",{staticClass:"content"},[s("cube-input",{model:{value:e.currentAddress.phone,callback:function(t){e.$set(e.currentAddress,"phone",t)},expression:"currentAddress.phone"}}),e._v(" "),s("cube-validator",{ref:"validator1",attrs:{model:e.currentAddress.phone,rules:e.phoneRules},model:{value:e.result[1],callback:function(t){e.$set(e.result,1,t)},expression:"result[1]"}})],1)]),e._v(" "),s("li",{staticClass:"item",on:{click:e.showAddressPicker}},[s("div",{staticClass:"text"},[e._v("所在地区")]),e._v(" "),s("div",{staticClass:"content"},[e._v("\n                    "+e._s(e.currentAddress.province)+"\n                    "+e._s(e.currentAddress.city)+"\n                    "+e._s(e.currentAddress.area)+"\n                    "),s("cube-validator",{ref:"validator3",attrs:{model:e.currentAddress.province,rules:e.provinceRules},model:{value:e.result[3],callback:function(t){e.$set(e.result,3,t)},expression:"result[3]"}})],1),e._v(" "),s("div",[e._v(" > ")])]),e._v(" "),s("li",{staticClass:"item"},[s("div",{staticClass:"text"},[e._v("详细地址")]),e._v(" "),s("div",{staticClass:"content"},[s("cube-textarea",{staticClass:"detail-address",attrs:{placeholder:"请输入"},on:{blur:e._blur},model:{value:e.currentAddress.address,callback:function(t){e.$set(e.currentAddress,"address",t)},expression:"currentAddress.address"}}),e._v(" "),s("cube-validator",{ref:"validator2",attrs:{model:e.currentAddress.address,rules:e.addressRules},model:{value:e.result[2],callback:function(t){e.$set(e.result,2,t)},expression:"result[2]"}})],1)]),e._v(" "),s("li",{staticClass:"item"},[s("div",{staticClass:"text"},[e._v("设置默认")]),e._v(" "),s("cube-switch",{model:{value:e.hasDefault,callback:function(t){e.hasDefault=t},expression:"hasDefault"}})],1)])])],1),e._v(" "),s("div",{staticClass:"address-add"},[s("div",{staticClass:"btn",on:{click:function(t){e._save()}}},[e._v("保存")])]),e._v(" "),s("cube-drawer",{ref:"drawer",staticClass:"order-page",attrs:{title:"请选择",data:e.data,"selected-index":e.selectedIndex},on:{change:e.changeHandler,select:e.selectHandler,cancel:e.cancelHandler}})],1)},staticRenderFns:[]};var l=s("VU/8")(r,n,!1,function(e){s("DapG")},"data-v-7d6dbfa8",null);t.default=l.exports},DapG:function(e,t,s){var i=s("gZlC");"string"==typeof i&&(i=[[e.i,i,""]]),i.locals&&(e.exports=i.locals);s("rjj0")("6efd035c",i,!0,null)},gZlC:function(e,t,s){(e.exports=s("FZ+f")(!0)).push([e.i,'\n.address-edit[data-v-7d6dbfa8]{height:100vh;font-family:HiraginoSansGB-W3;background-color:#fff;content:"viewport-units-buggyfill; height: 100vh"\n}\n.address-edit .address-list[data-v-7d6dbfa8]{height:calc(100vh - 16vw);content:"viewport-units-buggyfill; height: calc(100vh - 16vw)"\n}\n.address-edit .address-list .list[data-v-7d6dbfa8]{padding:0 1.6vw;content:"viewport-units-buggyfill; padding: 0 1.6vw"\n}\n.address-edit .address-list .list .item[data-v-7d6dbfa8]{min-height:13.067vw;padding:3.2vw 0;border-bottom:.5px solid #f2f2f2;display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-align:center;-ms-flex-align:center;align-items:center;-webkit-box-pack:justify;-ms-flex-pack:justify;justify-content:space-between;position:relative;content:"viewport-units-buggyfill; min-height: 13.067vw; padding: 3.2vw 0"\n}\n.address-edit .address-list .list .item .text[data-v-7d6dbfa8]{width:16vw;margin:0 2.133vw;font-size:3.733vw;color:#333;content:"viewport-units-buggyfill; width: 16vw; margin: 0 2.133vw; font-size: 3.733vw"\n}\n.address-edit .address-list .list .item .content[data-v-7d6dbfa8]{-webkit-box-flex:1;-ms-flex:auto;flex:auto;text-align:left;color:#ccc\n}\n.address-edit .address-add[data-v-7d6dbfa8]{height:16vw;content:"viewport-units-buggyfill; height: 16vw"\n}\n.address-edit .address-add .btn[data-v-7d6dbfa8]{margin:1.333vw auto;width:80vw;height:13.067vw;line-height:13.067vw;color:#fff;text-align:center;background:#4a4c59;border-radius:1.333vw;content:"viewport-units-buggyfill; margin: 1.333vw auto; width: 80vw; height: 13.067vw; line-height: 13.067vw; border-radius: 1.333vw"\n}',"",{version:3,sources:["G:/project/mall/src/views/address-edit/index.vue"],names:[],mappings:";AACA,+BAA+B,aAAa,8BAA8B,sBAAsB,iDAAiD;CAChJ;AACD,6CAA6C,0BAA0B,8DAA8D;CACpI;AACD,mDAAmD,gBAAgB,oDAAoD;CACtH;AACD,yDAAyD,oBAAoB,gBAAgB,iCAAiC,oBAAoB,oBAAoB,aAAa,yBAAyB,sBAAsB,mBAAmB,yBAAyB,sBAAsB,8BAA8B,kBAAkB,0EAA0E;CAC7Z;AACD,+DAA+D,WAAW,iBAAiB,kBAAkB,WAAW,sFAAsF;CAC7M;AACD,kEAAkE,mBAAmB,cAAc,UAAU,gBAAgB,UAAU;CACtI;AACD,4CAA4C,YAAY,gDAAgD;CACvG;AACD,iDAAiD,oBAAoB,WAAW,gBAAgB,qBAAqB,WAAW,kBAAkB,mBAAmB,sBAAsB,sIAAsI;CAChU",file:"index.vue",sourcesContent:['\n.address-edit[data-v-7d6dbfa8]{height:100vh;font-family:HiraginoSansGB-W3;background-color:#fff;content:"viewport-units-buggyfill; height: 100vh"\n}\n.address-edit .address-list[data-v-7d6dbfa8]{height:calc(100vh - 16vw);content:"viewport-units-buggyfill; height: calc(100vh - 16vw)"\n}\n.address-edit .address-list .list[data-v-7d6dbfa8]{padding:0 1.6vw;content:"viewport-units-buggyfill; padding: 0 1.6vw"\n}\n.address-edit .address-list .list .item[data-v-7d6dbfa8]{min-height:13.067vw;padding:3.2vw 0;border-bottom:.5px solid #f2f2f2;display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-align:center;-ms-flex-align:center;align-items:center;-webkit-box-pack:justify;-ms-flex-pack:justify;justify-content:space-between;position:relative;content:"viewport-units-buggyfill; min-height: 13.067vw; padding: 3.2vw 0"\n}\n.address-edit .address-list .list .item .text[data-v-7d6dbfa8]{width:16vw;margin:0 2.133vw;font-size:3.733vw;color:#333;content:"viewport-units-buggyfill; width: 16vw; margin: 0 2.133vw; font-size: 3.733vw"\n}\n.address-edit .address-list .list .item .content[data-v-7d6dbfa8]{-webkit-box-flex:1;-ms-flex:auto;flex:auto;text-align:left;color:#ccc\n}\n.address-edit .address-add[data-v-7d6dbfa8]{height:16vw;content:"viewport-units-buggyfill; height: 16vw"\n}\n.address-edit .address-add .btn[data-v-7d6dbfa8]{margin:1.333vw auto;width:80vw;height:13.067vw;line-height:13.067vw;color:#fff;text-align:center;background:#4a4c59;border-radius:1.333vw;content:"viewport-units-buggyfill; margin: 1.333vw auto; width: 80vw; height: 13.067vw; line-height: 13.067vw; border-radius: 1.333vw"\n}'],sourceRoot:""}])}});
//# sourceMappingURL=11.58bbe02747d1e38fc3f8.js.map