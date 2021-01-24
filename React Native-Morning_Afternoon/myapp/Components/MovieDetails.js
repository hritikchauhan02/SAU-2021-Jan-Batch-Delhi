import React, {useState}  from 'react';
import { StyleSheet, FlatList, Text, View, ScrollView, Image, TouchableOpacity, Modal, Linking } from 'react-native';

export default function MovieDetails ({route}) {
    const movie = route.params;
    //console.log(movie)

    const [modalVisible, setModalVisible] = useState(false);
    const imageUrl = "http://image.tmdb.org/t/p/w500" + movie.poster_path

    return (
        <View>
            <ScrollView style={styles.scrollView}>
            <Modal visible={modalVisible} animationType='slide'>
                <View style={styles.centeredView}>
                    <Text style={{fontSize: 24}}>You clicked {movie.original_title}</Text>
                
                <TouchableOpacity style={styles.modalButton} onPress={() => setModalVisible(false)}>
                    <View style={styles.customButton}>
                    <Text style={{color: 'white', fontSize: 16, fontWeight: '700'}}>
                    Close Modal
                    </Text>
                    </View>
                </TouchableOpacity>
                </View>
            </Modal>
            <Image
                style={{
                    width: '100%',
                    height: 400
                  }}
                source={{uri: imageUrl}}
                resizeMode="cover"
            />
            <Text style={styles.heading}>{movie.original_title}      {movie.release_date}     Popularity : {movie.popularity}</Text>
            <View style={styles.navView}>
                <TouchableOpacity onPress={() => setModalVisible(true)}>
                <View style={styles.customButton}>
                <Text style={{color: 'white', fontSize: 16, fontWeight: '700'}}>
                   Click Me
                </Text>
                </View>
                </TouchableOpacity>
                <TouchableOpacity onPress={() => Linking.openURL('https://www.accolite.com/')}>
                    <View style={styles.customButton}>
                    <Text style={{color: 'white', fontSize: 16, fontWeight: '700'}}>
                        View Details
                    </Text>
                    </View>
                </TouchableOpacity>  
            </View>
            
                    <Text style={styles.plot}>{movie.overview}</Text>
                    <Text style={styles.plot}>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nulla facilisi morbi tempus iaculis urna id volutpat. Nulla aliquet porttitor lacus luctus accumsan tortor posuere ac. Egestas egestas fringilla phasellus faucibus scelerisque eleifend donec pretium vulputate. Sed viverra ipsum nunc aliquet. Facilisis mauris sit amet massa. Eu facilisis sed odio morbi quis commodo. Quis auctor elit sed vulputate. Non odio euismod lacinia at quis risus sed. Porta lorem mollis aliquam ut. Ultrices dui sapien eget mi.
                    </Text>
                    <Text style={styles.plot}>
                        Vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt ornare. Egestas pretium aenean pharetra magna ac placerat vestibulum. In fermentum et sollicitudin ac orci. Semper quis lectus nulla at volutpat diam ut venenatis tellus. Eget sit amet tellus cras adipiscing enim eu turpis egestas. Quam viverra orci sagittis eu volutpat odio. Consectetur a erat nam at lectus urna. Phasellus vestibulum lorem sed risus ultricies tristique nulla. Et netus et malesuada fames ac. Consectetur adipiscing elit pellentesque habitant morbi. Et ligula ullamcorper malesuada proin libero nunc.
                    </Text>
            </ScrollView>
        </View>
    )
}

const styles = StyleSheet.create({
    heading: {
        display: 'flex',
        color: "#fff",
        fontSize: 18,
        fontWeight: '500',
        padding: 11,
        backgroundColor: "#445565",
        width: '100%',
        justifyContent: 'space-around'
      },
      navView: {
        width: '100%',
        flexDirection: 'row',
        display: 'flex',
        justifyContent: 'space-around'
      },
      customButton: {
        marginTop: '5%',
        width: '100%',
        marginLeft: '10%',
        backgroundColor: 'purple',
        alignItems: 'center',
        justifyContent: 'space-evenly',
        borderRadius: 8,
        padding: 16,
      },
      scrollView: {
          padding: 10,
      },
      plot: {
        fontWeight: '400',
        fontSize: 16,
        paddingBottom: 10
      },
      modalButton: {
          alignItems: 'center',
          width: '50%'
      },
      centeredView: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
        marginTop: 22,
      },
})