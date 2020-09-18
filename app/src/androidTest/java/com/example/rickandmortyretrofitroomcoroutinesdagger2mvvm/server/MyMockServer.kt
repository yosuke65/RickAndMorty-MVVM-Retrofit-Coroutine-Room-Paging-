package com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.server

import android.content.res.AssetManager
import android.util.JsonReader
import com.example.rickandmortyretrofitroomcoroutinesdagger2mvvm.R
import com.google.gson.GsonBuilder
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.io.FileReader


class MyMockServer {
    //  valid response dispatcher
    class ResponseDispatcher : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse {
            return MockResponse().setResponseCode(200).setBody(
                "{\n" +
                        "  \"info\": {\n" +
                        "    \"count\": 671,\n" +
                        "    \"pages\": 34,\n" +
                        "    \"next\": \"https://rickandmortyapi.com/api/character?page=2\",\n" +
                        "    \"prev\": null\n" +
                        "  },\n" +
                        "  \"results\": [{\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"Rick Sanchez\",\n" +
                        "    \"status\": \"Alive\",\n" +
                        "    \"species\": \"Human\",\n" +
                        "    \"type\": \"\",\n" +
                        "    \"gender\": \"Male\",\n" +
                        "    \"origin\": {\n" +
                        "      \"name\": \"Earth (C-137)\",\n" +
                        "      \"url\": \"https://rickandmortyapi.com/api/location/1\"\n" +
                        "    },\n" +
                        "    \"location\": {\n" +
                        "      \"name\": \"Earth (Replacement Dimension)\",\n" +
                        "      \"url\": \"https://rickandmortyapi.com/api/location/20\"\n" +
                        "    },\n" +
                        "    \"image\": \"https://rickandmortyapi.com/api/character/avatar/1.jpeg\",\n" +
                        "    \"episode\": [\n" +
                        "      \"https://rickandmortyapi.com/api/episode/1\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/2\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/3\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/4\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/5\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/6\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/7\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/8\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/9\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/10\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/11\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/12\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/13\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/14\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/15\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/16\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/17\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/18\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/19\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/20\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/21\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/22\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/23\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/24\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/25\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/26\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/27\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/28\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/29\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/30\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/31\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/32\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/33\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/34\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/35\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/36\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/37\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/38\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/39\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/40\",\n" +
                        "      \"https://rickandmortyapi.com/api/episode/41\"\n" +
                        "    ],\n" +
                        "    \"url\": \"https://rickandmortyapi.com/api/character/1\",\n" +
                        "    \"created\": \"2017-11-04T18:48:46.250Z\"\n" +
                        "  },\n" +
                        "    {\n" +
                        "      \"id\": 2,\n" +
                        "      \"name\": \"Morty Smith\",\n" +
                        "      \"status\": \"Alive\",\n" +
                        "      \"species\": \"Human\",\n" +
                        "      \"type\": \"\",\n" +
                        "      \"gender\": \"Male\",\n" +
                        "      \"origin\": {\n" +
                        "        \"name\": \"Earth (C-137)\",\n" +
                        "        \"url\": \"https://rickandmortyapi.com/api/location/1\"\n" +
                        "      },\n" +
                        "      \"location\": {\n" +
                        "        \"name\": \"Earth (Replacement Dimension)\",\n" +
                        "        \"url\": \"https://rickandmortyapi.com/api/location/20\"\n" +
                        "      },\n" +
                        "      \"image\": \"https://rickandmortyapi.com/api/character/avatar/2.jpeg\",\n" +
                        "      \"episode\": [\n" +
                        "        \"https://rickandmortyapi.com/api/episode/1\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/2\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/3\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/4\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/5\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/6\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/7\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/8\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/9\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/10\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/11\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/12\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/13\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/14\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/15\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/16\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/17\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/18\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/19\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/20\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/21\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/22\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/23\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/24\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/25\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/26\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/27\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/28\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/29\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/30\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/31\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/32\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/33\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/34\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/35\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/36\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/37\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/38\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/39\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/40\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/41\"\n" +
                        "      ],\n" +
                        "      \"url\": \"https://rickandmortyapi.com/api/character/2\",\n" +
                        "      \"created\": \"2017-11-04T18:50:21.651Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": 3,\n" +
                        "      \"name\": \"Summer Smith\",\n" +
                        "      \"status\": \"Alive\",\n" +
                        "      \"species\": \"Human\",\n" +
                        "      \"type\": \"\",\n" +
                        "      \"gender\": \"Female\",\n" +
                        "      \"origin\": {\n" +
                        "        \"name\": \"Earth (Replacement Dimension)\",\n" +
                        "        \"url\": \"https://rickandmortyapi.com/api/location/20\"\n" +
                        "      },\n" +
                        "      \"location\": {\n" +
                        "        \"name\": \"Earth (Replacement Dimension)\",\n" +
                        "        \"url\": \"https://rickandmortyapi.com/api/location/20\"\n" +
                        "      },\n" +
                        "      \"image\": \"https://rickandmortyapi.com/api/character/avatar/3.jpeg\",\n" +
                        "      \"episode\": [\n" +
                        "        \"https://rickandmortyapi.com/api/episode/6\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/7\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/8\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/9\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/10\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/11\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/12\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/14\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/15\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/16\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/17\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/18\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/19\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/20\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/21\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/22\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/23\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/24\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/25\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/26\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/27\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/29\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/30\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/31\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/32\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/33\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/34\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/35\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/36\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/38\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/39\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/40\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/41\"\n" +
                        "      ],\n" +
                        "      \"url\": \"https://rickandmortyapi.com/api/character/3\",\n" +
                        "      \"created\": \"2017-11-04T19:09:56.428Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": 4,\n" +
                        "      \"name\": \"Beth Smith\",\n" +
                        "      \"status\": \"Alive\",\n" +
                        "      \"species\": \"Human\",\n" +
                        "      \"type\": \"\",\n" +
                        "      \"gender\": \"Female\",\n" +
                        "      \"origin\": {\n" +
                        "        \"name\": \"Earth (Replacement Dimension)\",\n" +
                        "        \"url\": \"https://rickandmortyapi.com/api/location/20\"\n" +
                        "      },\n" +
                        "      \"location\": {\n" +
                        "        \"name\": \"Earth (Replacement Dimension)\",\n" +
                        "        \"url\": \"https://rickandmortyapi.com/api/location/20\"\n" +
                        "      },\n" +
                        "      \"image\": \"https://rickandmortyapi.com/api/character/avatar/4.jpeg\",\n" +
                        "      \"episode\": [\n" +
                        "        \"https://rickandmortyapi.com/api/episode/6\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/7\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/8\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/9\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/10\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/11\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/12\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/14\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/15\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/16\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/18\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/19\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/20\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/21\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/22\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/23\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/24\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/25\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/26\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/27\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/28\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/29\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/30\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/31\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/32\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/33\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/34\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/35\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/36\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/38\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/39\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/40\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/41\"\n" +
                        "      ],\n" +
                        "      \"url\": \"https://rickandmortyapi.com/api/character/4\",\n" +
                        "      \"created\": \"2017-11-04T19:22:43.665Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": 5,\n" +
                        "      \"name\": \"Jerry Smith\",\n" +
                        "      \"status\": \"Alive\",\n" +
                        "      \"species\": \"Human\",\n" +
                        "      \"type\": \"\",\n" +
                        "      \"gender\": \"Male\",\n" +
                        "      \"origin\": {\n" +
                        "        \"name\": \"Earth (Replacement Dimension)\",\n" +
                        "        \"url\": \"https://rickandmortyapi.com/api/location/20\"\n" +
                        "      },\n" +
                        "      \"location\": {\n" +
                        "        \"name\": \"Earth (Replacement Dimension)\",\n" +
                        "        \"url\": \"https://rickandmortyapi.com/api/location/20\"\n" +
                        "      },\n" +
                        "      \"image\": \"https://rickandmortyapi.com/api/character/avatar/5.jpeg\",\n" +
                        "      \"episode\": [\n" +
                        "        \"https://rickandmortyapi.com/api/episode/6\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/7\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/8\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/9\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/10\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/11\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/12\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/13\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/14\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/15\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/16\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/18\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/19\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/20\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/21\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/22\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/23\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/26\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/29\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/30\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/31\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/32\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/33\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/35\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/36\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/38\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/39\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/40\",\n" +
                        "        \"https://rickandmortyapi.com/api/episode/41\"\n" +
                        "      ],\n" +
                        "      \"url\": \"https://rickandmortyapi.com/api/character/5\",\n" +
                        "      \"created\": \"2017-11-04T19:26:56.301Z\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}"
            )
        }

    }

    class ErrorDispatcher:Dispatcher(){
        override fun dispatch(request: RecordedRequest): MockResponse {
            return MockResponse().setResponseCode(400)
        }

    }
}