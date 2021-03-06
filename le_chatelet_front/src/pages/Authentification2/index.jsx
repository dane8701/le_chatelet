import styled from 'styled-components'
import React from 'react'
import logo from '../../assets/logo.png'
import {response} from './../../scripts/checkIP'
import {axios} from 'axios'
import { Navigate } from "react-router-dom"


const DivForm = styled.form `
    position: absolute;
    width: 705px;
    height: 425px;
    background: #FFFFFF;
    box-shadow: 4px 10px 4px rgba(0, 0, 0, 0.25);
    border-radius: 50px;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    padding: 50px
`

const LabelForm = styled.label `
    font-family: Roboto;
    font-style: normal;
    font-weight: normal;
    font-size: 24px;
    line-height: 28px;
    color: #000000;
`

const InputForm = styled.input `
    width: 75vh;
    height: 60px;
    background: #FFFFFF;
    padding: 10px;
    font-size: 24px;
    border: 0.5px solid rgba(0, 0, 0, 0.1);
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    border-radius: 10px;
    margin-top: 5px;
    &:focus {
        outline: none;
    }

`

const SubmitForm = styled.input `
    width: 255px;
    height: 65px;

    background: #0D79CA;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    border-radius: 10px;
    color: #FFFFFF;
    font-family: Roboto;
    font-style: normal;
    font-weight: normal;
    font-size: 30px;
    line-height: 35px;
`

const TitleForm = styled.label `
    font-family: Montserrat;
    font-style: normal;
    font-weight: bold;
    font-size: 40px;
    line-height: 49px;
    color: #000000;
`

const Logo = styled.img `
    width: 580px;
    height: 105px;
    margin-top: 5vh;
`

export default class Home extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            user: {
                lastName: "",
                firstName: "",
                login: "",
                number: "",
                mail: "",
                token: "",
            },
            res: undefined,
        };
        this._method = this._method.bind(this)

    }

    componentDidMount(){
        response();
    }

    componentWillMount(){
        this._method()
    }

    _method() {
        var ip = ""
        axios.get("http://ipwhois.app/json/" + ip)
        .then((response)=> {
            var location = response.data
            console.log("SUCCESS")
            console.log(location.country);
            if(location.country_code === "FR") {
                this.setState({ res: false })
                // return 0
            }
            else {
                // console.log("1")
                this.setState({ res: true })
                // return 1
            }
        })
        .catch((error)=> {
            this.setState({ res: true })
            // return 1
        });
    }

    handle(e) {
        const newUser = {...this.state.user}
        newUser[e.target.id] = e.target.value
        this.setState({ user: newUser })
    }

    sendCode(e) {
        // e.preventDefault();
        console.log("order")
        const user = this.state.user
        console.log(user)
        axios.post("http://localhost:8080/user/2fa", {
            user
        })
        .then((response) => {
            console.log(response)
            // this.props.history.push('/')
        })
        .catch((error) => console.error(error))
    }

    render() {
        return this.state.res ? <Navigate to='/country'/> : (
            <div style={{ display: 'block', height: '100vh'}}>
                <div style={{ backgroundColor: '#0D79CA', height: '50vh', textAlign: 'center'}}>
                    <Logo src={logo} alt="logo" />
                </div>
                <div style={{ backgroundColor: '#EEF2F6', height: '50vh'}}>
                <DivForm onSubmit={(e) => this.login(e)}>
                    <center><TitleForm>Connexion</TitleForm></center>
                    <div style={{marginTop: '25px'}}>
                        <LabelForm>ENTREZ LE CODE D???AUTHENTIFICATION :</LabelForm>
                        <br/>
                        <InputForm onChange={(e) => this.handle(e)} id="token" value={this.state.user.username} label="token" type='text' name="token" placeholder="Code d???authentification ?? 6 chiffres"/>
                    </div>
                    <div style={{marginTop: '25px', textAlign: 'center'}}>
                        <SubmitForm type='submit' name="valider" value="V??rifier"/>
                    </div>
                </DivForm>

                </div>
            </div>
        );
    }
}