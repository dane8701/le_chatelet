import styled from 'styled-components'
import logo from '../../assets/logo.png'

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

export default function Home () {
    return (
        <div style={{ display: 'block', height: '100vh'}}>
            <div style={{ backgroundColor: '#0D79CA', height: '50vh', textAlign: 'center'}}>
                <Logo src={logo} alt="logo" />
            </div>
            <div style={{ backgroundColor: '#EEF2F6', height: '50vh'}}>
            <DivForm>
                <center><TitleForm>Connexion</TitleForm></center>
                <div style={{marginTop: '25px'}}>
                    <LabelForm>Nom d'utilisateur</LabelForm>
                    <br/>
                    <InputForm type='text' name="username" placeholder=""/>
                </div>
                <div style={{marginTop: '25px'}}>
                    <LabelForm>Mot de passe</LabelForm>
                    <br/>
                    <InputForm type='password' name="password" placeholder=""/>
                </div>
                <div style={{marginTop: '25px', textAlign: 'center'}}>
                    <SubmitForm type='submit' name="valider" value="Se connecter"/>
                </div>
            </DivForm>
                
            </div>
        </div>
    );
}