function Maps(){
	var maps = [
			[ 
				[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ], 
				[ 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 ],
				[ 0, 0, 0, 0, 1, 4, 1, 0, 0, 0 ], 
				[ 0, 1, 1, 1, 1, 3, 1, 0, 0, 0 ], 
				[ 0, 1, 4, 2, 3, 5, 1, 1, 1, 0 ],
				[ 0, 1, 1, 1, 3, 2, 3, 4, 1, 0 ], 
				[ 0, 0, 0, 1, 2, 1, 1, 1, 1, 0 ], 
				[ 0, 0, 0, 1, 4, 1, 0, 0, 0, 0 ],
				[ 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 ], 
				[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ]
			],
			[ 
				[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ], 
				[ 0, 0, 1, 1, 1, 1, 1, 1, 1, 0 ], 
				[ 0, 0, 1, 2, 5, 4, 4, 4, 1, 0 ],
				[ 0, 0, 1, 2, 2, 2, 2, 2, 1, 1 ], 
				[ 0, 1, 1, 1, 3, 2, 2, 2, 2, 1 ],
				[ 0, 1, 2, 2, 2, 2, 2, 2, 2, 1 ], 
				[ 0, 1, 2, 3, 2, 1, 3, 1, 2, 1 ],
				[ 0, 1, 2, 2, 2, 1, 2, 2, 2, 1 ], 
				[ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 ],
				[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ], 
			],
			[
				[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ], 
				[ 0, 1, 1, 1, 1, 1, 0, 0, 0, 0 ],
				[ 0, 1, 2, 2, 5, 1, 0, 0, 0, 0 ], 
				[ 0, 1, 2, 3, 3, 1, 0, 1, 1, 1 ],
				[ 0, 1, 2, 3, 2, 1, 0, 1, 4, 1 ], 
				[ 0, 1, 1, 1, 2, 1, 1, 1, 4, 1 ],
				[ 0, 0, 1, 1, 2, 2, 2, 2, 4, 1 ], 
				[ 0, 0, 1, 2, 2, 2, 1, 2, 2, 1 ],
				[ 0, 0, 1, 2, 2, 2, 1, 1, 1, 1 ], 
				[ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0 ]
				
			],
			[
				[0,0,0,0,0,0,0,0,0,0],
				[0,1,1,1,1,1,1,1,0,0],
				[0,1,2,2,2,2,2,1,1,1],
				[1,1,3,1,1,1,2,2,2,1],
				[1,5,2,2,3,2,2,3,2,1],
				[1,2,4,4,1,2,3,2,1,1],
				[1,1,4,4,1,2,2,2,1,0],
				[0,1,1,1,1,1,1,1,1,0],
				[0,0,0,0,0,0,0,0,0,0],
				[0,0,0,0,0,0,0,0,0,0]
			],
			[
				[0,0,0,0,0,0,0,0,0,0],
				[0,0,0,1,1,1,1,0,0,0],
				[0,0,1,1,2,2,1,0,0,0],
				[0,0,1,5,3,2,1,0,0,0],
				[0,0,1,1,3,2,1,1,0,0],
				[0,0,1,1,2,3,2,1,0,0],
				[0,0,1,4,3,2,2,1,0,0],
				[0,0,1,4,4,9,4,1,0,0],
				[0,0,1,1,1,1,1,1,0,0],
				[0,0,0,0,0,0,0,0,0,0]
			]
		];	
	// 关数
	this.index = 0;
	// 本地地图
	this.next = function (){
		return maps [ this.index ++ % maps.length ];
	}
	
	this.next = async function (){
		this.index ++;
		// 异步调用  不等待
		// 等待 get 方法的执行结束
		var ret = await axios.get("getMap?index=" + this.index)
			.then( function(res){
				// 将 json 字符串转成 js 对象(  地图二维数组 )
				//var ret = JSON.parse(res.data);
				// axios 会自动的帮我们转换 js 对象
				// axios 返回的数据 是 res.data
				return res.data;
			}, ()=>{
				return this.maps[this.index];
			});
		return ret;
	}
}

