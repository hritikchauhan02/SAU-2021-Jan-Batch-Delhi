import React from 'react';
import {View, StyleSheet, ImageBackground, Image, TouchableOpacity, Text} from 'react-native';

var logo = require('../assets/splash.png');
var bg = require('../background.jpg');

export default function Splash ({navigation}) {

    return (
        <ImageBackground
            source={bg}
            style={{height:'100%', width: '100%'}}
            >
                <Text style={{
                    marginTop:'40%',
                    justifyContent:'center',
                    textAlign: 'center',
                    fontSize: 64,
                    fontWeight: '800',
                    color: 'white'
                }}>HMDB</Text>
            <View style={{
                felx: 1,
                justifyContent: 'center',
                alignItems: 'center'
            }}>
                <TouchableOpacity style={styles.modalButton} onPress={() => navigation.navigate('Home')}>
                    <View style={styles.customButton}>
                        <Text style={{color: 'white', fontSize: 16, fontWeight: '700'}}>
                        Enter HMDB
                        </Text>
                    </View>
                </TouchableOpacity>
            </View>
        </ImageBackground>
    )
}

const styles = StyleSheet.create({
    customButton: {
        marginTop:'50%',
        width: '100%',
        backgroundColor: 'purple',
        alignItems: 'center',
        justifyContent: 'space-evenly',
        borderRadius: 8,
        padding: 16,
      },
})