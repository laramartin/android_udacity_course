# Android Networking

## Comparing app with & without loaders

Without loaders, every time the phone is rotated, a new Activity is created, executing the AsyncTask which makes a new HTTP request. Note the spikes in the Network monitor. 

<img src="https://raw.githubusercontent.com/laramartin/android_udacity_course/master/android_networking/ud843_QuakeReport/quake_without_loaders.PNG"/>

With loaders, once the app is launched and the activity is created, the loader is created and executed, which will store the data. If the phone is rotated while the loader executes the AsyncTask, a new execution of the AsyncTask won't happen. In the following screenshot the phone was rotated several times, but as expected there's a lack of spikes in Network monitor. 

<img src="https://raw.githubusercontent.com/laramartin/android_udacity_course/master/android_networking/ud843_QuakeReport/quake_with_loaders.PNG"/>
