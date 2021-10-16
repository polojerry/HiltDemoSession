package com.samples.local

import com.samples.local.entity.FavouriteEntity

object Fakes {

    val favourite = FavouriteEntity(
        sourceName = "Engadget",
        author = "Kris Holt",
        title = "Microsoft Edge update adds tab groups and new shopping features",
        url = "https://www.engadget.com/microsoft-edge-tab-groups-shopping-features-travel-news-185421812.html",
        imageUrl = "https://s.yimg.com/os/creatr-uploaded-images/2021-09/26a74670-1c9e-11ec-ab3f-01e751891c2b",
        publishDate = "2021-09-20T23:04:03Z",
        content = "Just ahead of the Windows 11 launch\r\n,"
    )

    val favourite1 = FavouriteEntity(
        sourceName = "Yahoo Entertainment",
        author = "CBS News Videos",
        title = "\"CBS Evening News\" headlines for Monday, September 20, 2021",
        url = "https://news.yahoo.com/cbs-evening-news-headlines-monday-230403005.html",
        imageUrl = "https://s.yimg.com/hd/cp-video-transcode/prod/2021-09/20/6149166b05530c31008eeed6/6149166b05530c31008eeed7_o_U_v2.jpg",
        publishDate = "2021-09-20T23:04:03Z",
        content = "Michael M Santiago/GettyImagesProsecutors have... "
    )
}