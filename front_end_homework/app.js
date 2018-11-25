
   var vm=new Vue({
   el:"#app",
   //打开网页之后默认的几门课程
   data:{
    totalscore:0,
    animatenum:0,
    item:{
      id:'',
      name:'',
      credit:0,
      score:0
    },
    message:[
    {
        id: 'CS902',
        name: '程序设计思想与方法',
        credit: 3,
        score: 86
     },{
        id: 'MA115',
        name: '离散数学',
        credit: 2,
        score: 95
     },{
        id: 'MA077',
        name: '线性代数',
        credit: 3,
        score: 86
     },{
        id: 'TH004',
        name: '军事理论',
        credit: 1,
        score: 90
      }
    ]
   },
   watch:{
    toComput2:function(newValue,oldValue){
    this.tween(newValue,oldValue);
    }
   },
   computed:{
    //计算总学积分
    toComput2:function(){
    var vm=this;
    //每次进来要重置总学积分
    vm.totalscore=0;
    vm.totalcredit=0;
    this.message.forEach(function(mess){
     vm.totalscore+=parseInt(mess.credit*mess.score);
     vm.totalcredit+=parseInt(mess.credit);
    })
    return this.totalscore/this.totalcredit;
    }
   },
   filters:{
    filtermoney:function(value){
      return value ;
    }
   },
   mounted:function(){ 
    this.tween('88.44','0');
   },
   methods:{
    addcourse:function(){
      this.message.push(this.item);
      this.item = {
        id:'',
        name:'',
        credit:0,
        score:0
      };
    },
    toComput:function(){
    var vm=this;
    vm.message.forEach(function(mess){
     vm.totalscore+=parseInt(mess.credit*mess.score);
    })
    return vm.totalscore;
    },
    remove:function(index){
    var vm=this;
    if (confirm("你确定移除该课程？")) { 
        vm.message.splice(index,1)
      } 
    },
    jia:function(index){
    var vm=this;
    vm.arr[index].one++;
    },
    tween:function(newValue,oldValue){
   var vm=this;
   var twen=new TWEEN.Tween({animatenum:oldValue});
   function animate() {
     requestAnimationFrame(animate);  
     TWEEN.update(); 
   };
   twen.to({animatenum:newValue},750);
   twen.onUpdate(function(){
   //toFixed();保留几位小数
   vm.animatenum = this.animatenum.toFixed(2);
   })
   twen.start();
   animate();
  }
   }
   });
  