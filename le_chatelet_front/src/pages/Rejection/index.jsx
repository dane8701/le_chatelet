import styled from 'styled-components'
import logo from '../../assets/logo.png'
import refus from '../../assets/refus.png'


const Logo = styled.img `
    width: 580px;
    height: 105px;
    margin-top: 5vh;
`

const Refus = styled.img `
    position: absolute;
    width: 589px;
    height: 680px;
    top: 50%;
    left: 75%;
    transform: translate(-50%, -50%);
    background: url(refus.png);
    filter: drop-shadow(-316px -6px 4px rgba(0, 0, 0, 0.25));
`

const DivNameError = styled.div `
    position: absolute;
    left: 55px;
    top: 326px;
`
const NameError1 = styled.h1 `
    position: absolute;
    left: 55px;
    top: 20%;
    font-family: Risque;
    font-style: normal;
    font-weight: normal;
    font-size: 144px;
    line-height: 166px;
    color: #FFFFFF;
    text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
`
const NameError2 = styled.h1 `
    position: absolute;
    left: 55px;
    top: 40%;
    font-family: Risque;
    font-style: normal;
    font-weight: normal;
    font-size: 144px;
    line-height: 166px;
    color: #0D79CA;
    text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
`

export default function Rejection () {
    return (
        <div style={{ display: 'block', height: '100vh'}}>
            <div style={{ backgroundColor: '#0D79CA', height: '50vh', textAlign: 'center'}}>
                <Logo src={logo} alt="logo" />
            </div>
            <div style={{ backgroundColor: '#EEF2F6', height: '50vh'}}>
                <Refus src={refus} alt="refus" />
                <span>
                    <NameError1>Country</NameError1>
                    <br/>
                    <NameError2>REJECTION</NameError2>
                </span>
            </div>
        </div>
    );
}