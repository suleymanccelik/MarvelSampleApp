package com.suleymancelik.marvelapp.data


import com.squareup.moshi.Json

data class CharacterListModel(
    @field:Json(name = "attributionHTML")
    val attributionHTML: String,
    @field:Json(name = "attributionText")
    val attributionText: String,
    @field:Json(name = "code")
    val code: Int,
    @field:Json(name = "copyright")
    val copyright: String,
    @field:Json(name = "data")
    val characterListData: CharacterListData,
    @field:Json(name = "etag")
    val etag: String,
    @field:Json(name = "status")
    val status: String
)

data class CharacterListData(
    @field:Json(name = "count")
    val count: Int,
    @field:Json(name = "limit")
    val limit: Int,
    @field:Json(name = "offset")
    val offset: Int,
    @field:Json(name = "results")
    val characterListResults: List<CharacterListResult>,
    @field:Json(name = "total")
    val total: Int
)

data class CharacterListResult(
    @field:Json(name = "comics")
    val comicsData: ComicsData,
    @field:Json(name = "description")
    val description: String,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "modified")
    val modified: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "resourceURI")
    val resourceURI: String,
    @field:Json(name = "thumbnail")
    val comicsThumbnail: ComicsThumbnail
)

data class ComicsData(
    @field:Json(name = "available")
    val available: Int,
    @field:Json(name = "collectionURI")
    val collectionURI: String,
    @field:Json(name = "items")
    val comicsItems: List<ComicsItem>,
    @field:Json(name = "returned")
    val returned: Int
)

data class ComicsItem(
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "resourceURI")
    val resourceURI: String
)

data class ComicsThumbnail(
    @field:Json(name = "extension")
    val extension: String,
    @field:Json(name = "path")
    val path: String
)