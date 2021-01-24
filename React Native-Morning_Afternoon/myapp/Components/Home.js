import { StatusBar } from 'expo-status-bar';
import axios from 'axios';
import React, { useState, useEffect } from 'react';
import { StyleSheet, Text, View, TextInput, Button, TouchableOpacity } from 'react-native';
import MovieLayout from './MovieLayout';

export default function Home({navigation}) {

  var data = [];

  const url =  "https://api.themoviedb.org/3/movie/popular?api_key=128b43fd8b1d61249db5dd3228c0c099&language=en-US&page=";
  const [state, setstate] = useState({
    s: '',
    movies: [],
  });

  const getOtherData = () => {
    for(let i=2;i<=10;i++)
    {
      axios(url+i).then((item) => {

        for(let movies in item.data.results) {
          data.push(item.data.results[movies])
          
        }
        setstate(prevState => {
          return {...prevState, movies: data}
        })
      })
    }
  }

  const loadInitialData = () => {
    axios(url + "1").then((item) => {

        for(let movies in item.data.results) {
          data.push(item.data.results[movies])
          setstate(prevState => {
            return {...prevState, movies: data}
          })
        }

      })
      getOtherData();
  }

  useEffect(() => {
    loadInitialData();
  }, [])

  const clearSearchBox = () => {
    setstate(prevState => {
      return {...prevState, s: ''}
    })
  }

  const compare = (a,b) => {
    return a.title.localeCompare(b.title);
  }

  const sortOnYear = () => {
    const arr = state.movies;
    setstate(prevState => {
      return {...prevState, movies: [...arr].sort(compare)}
    })
  }

  const textChangeHandler = (text) => {
    setstate(prevState => {
      return {...prevState, s: text}
    })
  }

  return (
    <View style={styles.container}>
      <View style={styles.navView}>
        <TextInput 
          style={styles.searchbox} 
          value={state.s}
          onChangeText={textChangeHandler}
          />
          <TouchableOpacity onPress={clearSearchBox}>
            <View style={styles.customButton}>
              <Text style={{color: 'white', fontSize: 20, fontWeight: '800'}}>
                X
              </Text>
            </View>
          </TouchableOpacity>

          <TouchableOpacity onPress={sortOnYear}>
            <View style={styles.customButton}>
              <Text style={{color: 'white', fontSize: 20, fontWeight: '800'}}>
                S
              </Text>
            </View>
          </TouchableOpacity>
        </View>
        <MovieLayout data={state.movies.filter(movie => movie.title.toLowerCase().startsWith(state.s.toLowerCase()))}></MovieLayout>
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#223343',
    alignItems: 'center',
    justifyContent: 'center',
    paddingTop: 25,
    paddingHorizontal: 20
  },
  navView: {
    marginTop: 20,
    width: '100%',
    flexDirection: 'row'
  },
  searchbox: {
    fontSize: 20,
    fontWeight: '300',
    padding: 20,
    width: '60%',
    backgroundColor: '#fff',
    padding: 10,
    borderRadius: 8,
    marginBottom: 40,
  },
  results: {
    flex: 1
  },
  customButton: {
    marginLeft: '10%',
    backgroundColor: 'purple',
    alignItems: 'center',
    justifyContent: 'center',
    borderRadius: 8,
    padding: 11,
  },
});