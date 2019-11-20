import { Banner } from '../../model/banner'
import { Category } from '../../model/category'
import { Theme } from '../../model/theme'

Page({
  data: {
    themeA: null,
    bannerB: null,
    grid: []
  },

  onLoad: async function(options) {
    this.initAllData()
  },
  async initAllData() {
    const themeA = await Theme.getHomeLocationA()
    const bannerB = await Banner.getHomeLocationB()
    const grid = await Category.getGridCategory()
    this.setData({
      themeA: themeA[0],
      bannerB,
      grid
    })
  },

  onPullDownRefresh: function() {},
  onReachBottom: function() {},
  onShareAppMessage: function() {}
})
