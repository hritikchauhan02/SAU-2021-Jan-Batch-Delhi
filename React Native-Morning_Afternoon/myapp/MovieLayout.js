import React  from 'react';
import axios from 'axios';
import { StyleSheet, Text, View, FlatList, Image, TouchableHighlight, TouchableOpacity } from 'react-native';
import { useNavigation } from '@react-navigation/native';

export default function MovieLayout ({data}) {
    const navigationHandler = id => {
        // console.log(id)
        const url =  "https://api.themoviedb.org/3/movie/" + id + "?api_key=128b43fd8b1d61249db5dd3228c0c099&language=en-US";
        axios(url).then(({ data }) => {
            navigation.navigate('MovieDetails',data)
        })
    }

    const navigation = useNavigation();

    const renderItem = ({item}) => {
      //console.log(item)
      const id = item.id
      const imageUrl = "http://image.tmdb.org/t/p/w500" + item.poster_path;
      //console.log(imageUrl);
      return (
        <TouchableHighlight>
          <View style={styles.result}>
            <Image
              style={{
                width: '100%',
                height: 500
              }}
              source={{uri: imageUrl}}
              resizeMode="cover"
            />
            <View style={styles.movieTitleBlock}>
              <Text style={styles.heading}>{item.title}  {item.release_date}</Text>
              <TouchableOpacity onPress={() => navigationHandler(id)}>
                <View style={styles.customButton}>
                  <Text style={{color: 'white', fontSize: 12, fontWeight: '600'}}>
                    View Details
                  </Text>
                </View>
              </TouchableOpacity>
            </View>
          </View>
        </TouchableHighlight>
      )
    }


    return (
        <FlatList
          data = {data}
          renderItem = {renderItem}
          keyExtractor = {item => item.id.toString()}
        />
    )
}

const styles = StyleSheet.create({
    result: {
        flex: 1,
        width: '100%',
        marginBottom: 20
      },
      movieTitleBlock: {
        width: '65%',
        flexDirection: 'row'
      },
      heading: {
        color: "#fff",
        fontSize: 18,
        fontWeight: '500',
        padding: 11,
        backgroundColor: "#445565",
        width: '100%'
      },
      navView: {
    width: '100%',
    flexDirection: 'row'
  },
      customButton: {
        marginLeft: '10%',
        backgroundColor: 'purple',
        alignItems: 'center',
        justifyContent: 'center',
        borderRadius: 8,
        padding: 15,
      }
})