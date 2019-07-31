function Area({areaname,parentid}){
	this.areaname = areaname || ''
	this.parentid = parentid || '0'
	console.log(this.areaname)
	console.log(this.parentid)
}

Area.prototype = {
	constructor: Area,
	getSuggestion: function(){
		return new Promise((resolve,reject)=>{
			console.log(this.areaname)
			console.log(this.parentid)
			$.get("data",{method:'getAreaInfoByName',name:this.areaname,parentId:this.parentid},function(data){
				let datas = JSON.parse(data)
				resolve(datas)
			})
		})
	}
}