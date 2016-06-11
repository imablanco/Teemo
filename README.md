# Teemo
Teemo is an Androd library for Riot API.

It is built using Retrofit and SQLite for cache data (according to [Riot's rate limiting policy](https://developer.riotgames.com/docs/rate-limiting)).

# Usage

Specify your API key in Manifest.xml or 

```xml
   <meta-data
            android:name="com.ablanco.teemo.apikey"
            android:value="{API_KEY}" />
```

Or set it in code in Teemo's init method.

You can star Teemo specifying region or set ir later, but you won't be able to perform any calls before regions is set.

You will receive an IllegalStateException if you try to perform API calls before setting the region or if you try to start Teemo without specify the API key.

```java
Teemo.setArmedAndReady(this);
```

```java
Teemo.setArmedAndReady(this, region);
```

```java
Teemo.setArmedAndReady(this, apiKey, region);
```

You are able to change the region at runtime

```java
Teemo.getInstance(this).setRegion(region);
```

Once Teemo is started, you can star making API calls. Teemo has one handler per [Riot API](https://developer.riotgames.com/api/methods), so to retrieve Summoner's information you have to call

```java
Teemo.getInstance(this).getSummonersHandler().getSummonerById(super, new ServiceResponseListener<Summoner>() {
            @Override
            public void onResponse(Summoner response) {
                //do stuff
            }

            @Override
            public void onError(TeemoException e) {
                //handle error
            }
        });
```

All the API calls have the same structure.

**Note**

StaticData handler does not cache API responses as they do not count on Rate Limit.
 
# Disclaimer
Teemo isn't endorsed by Riot Games and doesn't reflect the views or opinions of Riot Games or anyone officially involved in producing or managing League of Legends. League of Legends and Riot Games are trademarks or registered trademarks of Riot Games, Inc. League of Legends © Riot Games, Inc.

# LICENSE
-------
Copyright 2016 Álvaro Blanco Cabrero

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
