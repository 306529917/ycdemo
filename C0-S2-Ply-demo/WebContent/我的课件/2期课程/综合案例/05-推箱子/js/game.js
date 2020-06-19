function Game() {
	// 地图对象
	this.maps = new Maps();
	// 地图 二维数组
	this.map = null;
	// 原始地图，用于恢复移动后的地板和判断游戏结束
	this.mapOld = null;
	// 游戏结束标志，如没有则每次都需判断地图
	this.isOver = null;
	// 记录移动的步数
	this.stepNumber = 0;

	// 获取下一张地图
	this.next = async function() {
		this.stepNumber = 0;
		this.isOver = false;
		this.map = await this.maps.next();
		this.mapOld = clone(this.map);
		return this.map;
	}

	/**
	 * 重来一次, index 表示关数(第一关是1), 不传入表示当前关从来,否则重来指定关数
	 */
	this.reset = function(index) {
		if(index){
			// 先设置为前一关
			this.maps.index = index - 1;
			// 再加载下一关( 当前关 )
			this.next();
		} else {
			// 重置属性
			this.stepNumber = 0;
			this.isOver = false;
			this.map = clone(this.mapOld);
			return this.map;
		}
	}

	/**
	 * 小人上移
	 */
	this.up = function() {
		var xy = this.moveMan(0, -1);
		this.map[xy[1]][xy[0]] = 8;
	}

	/**
	 * 小人下移
	 */
	this.down = function() {
		var xy = this.moveMan(0, 1);
		this.map[xy[1]][xy[0]] = 5;
	}

	/**
	 * 小人左移
	 */
	this.left = function() {
		var xy = this.moveMan(-1, 0);
		this.map[xy[1]][xy[0]] = 6;
	}

	/**
	 * 小人右移
	 */
	this.right = function() {
		var xy = this.moveMan(1, 0);
		this.map[xy[1]][xy[0]] = 7;
	}

	/**
	 * 移动小人
	 * @param ox
	 * @param oy
	 * @return 返回小人的坐标
	 */
	this.moveMan = function(ox, oy) {
		// 找到小人的坐标
		var xy = this.findMan();
		if (this.isOver) {
			return xy;
		}
		var x = xy[0];
		var y = xy[1];
		// 计算前面格子的坐标
		var tx = x + ox;
		var ty = y + oy;
		if (this.map[ty][tx] == 1) {
			// 前面是地图边界，返回
			return xy;
		} else if (this.map[ty][tx] == 3 || this.map[ty][tx] == 9) {
			// 前面是箱子, 先推动箱子
			xy = this.moveItem(tx, ty, ox, oy);
			// 如果背箱子压住是目的地, 那么箱子颜色变成9
			if (this.mapOld[xy[1]][xy[0]] == 4
					|| this.mapOld[xy[1]][xy[0]] == 9) {
				this.map[xy[1]][xy[0]] = 9;
			} else {
				this.map[xy[1]][xy[0]] = 3;
			}
		}
		// 移动小人
		var newxy = this.moveItem(x, y, ox, oy);
		// 只有移动后才计算步数
		if (newxy[0] != x || newxy[1] != y) {
			this.stepNumber++;
		}
		return newxy;
	}

	/**
	 * 移动物体( 小人或箱子 )
	 * @param x
	 * @param y
	 * @param ox
	 * @param oy
	 * @return 返回移动后的物体的坐标
	 */
	this.moveItem = function(x, y, ox, oy) {
		// 计算前面格子的坐标
		var tx = x + ox;
		var ty = y + oy;
		if (this.map[ty][tx] == 2 || this.map[ty][tx] == 4) {
			// 如果前面是空格和目的地, 则移动物体
			this.map[ty][tx] = this.map[y][x];
			// 恢复移动后的空格, 要从原始地图中获取原来的格子值
			this.map[y][x] = this.mapOld[y][x] == 4 || this.mapOld[y][x] == 9 ? 4
					: 2;
			return [ tx, ty ];
		}
		return [ x, y ];
	}

	/**
	 * 找小人的位置, 地图中为 5,6,7,8的格子
	 */
	this.findMan = function() {
		for (var y = 0; y < this.map.length; y++) {
			for (var x = 0; x < this.map[y].length; x++) {
				if (this.map[y][x] == 5 || this.map[y][x] == 6
						|| this.map[y][x] == 7 || this.map[y][x] == 8) {
					return [ x, y ];
				}
			}
		}
		return null;
	}

	/**
	 * 判断游戏是否结束, 就是地图上所得目的的格子( 值为4) 全部被箱子替换了, 这要用原始地图来判断
	 */
	this.youWin = function() {
		for (var y = 0; y < this.map.length; y++) {
			for (var x = 0; x < this.map[y].length; x++) {
				// 地图上有3号箱子就表示还没结束了
				if (this.map[y][x] == 3) {
					return false;
				}
			}
		}
		// 地图上没有3号箱子就结束了
		return true;
	}

	/**
	 * 加载游戏存档    dbgame 从数据库获取的存档对象(结构(属性)与当前对象一致, 但是没有函数)
	 */ 
	this.load = function(dbgame){
		this.map = dbgame.map;
		this.mapOld = dbgame.mapOld;
		this.isOver = dbgame.isOver;
		this.stepNumber = dbgame.stepNumber;
		this.maps.index = dbgame.maps.index;
	}

}

/**
 * 克隆对象, js没有克隆方法, 要自己写
 * @param Obj
 * @returns
 */
function clone(Obj) {
	var buf;
	if (Obj instanceof Array) {
		buf = [];
		var i = Obj.length;
		while (i--) {
			buf[i] = clone(Obj[i]);
		}
		return buf;
	} else if (Obj instanceof Object) {
		buf = {};
		for ( var k in Obj) {
			buf[k] = clone(Obj[k]);
		}
		return buf;
	} else {
		return Obj;
	}
}
