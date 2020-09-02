using System;
using System.Text.RegularExpressions;

namespace Codenation.Challenge
{
    public class CesarCypher : ICrypt, IDecrypt
    {
        public char[] caracteres = "abcdefghijklmnopqrstuvwxyz".ToCharArray();
        public Regex rgx = new Regex("^[a-zA-Z0-9 ]*$");
        public string Crypt(string message)
        {
            if (message == string.Empty)
            {
                return string.Empty;
            }

            if (message == null)
            {
                throw new ArgumentNullException();
            }

            char[] msgCifrada = message.ToLower().ToCharArray();

            if (rgx.IsMatch(message.ToLower()))
            {
                for (int i = 0; i < msgCifrada.Length; i++)
                {
                    int num = Array.IndexOf(caracteres, msgCifrada[i]);

                    if (num >= 0)
                    {
                        if ((num + 3) >= 26)
                        {
                            msgCifrada[i] = caracteres[num + 3 - 26];
                        }

                        else
                        {
                            msgCifrada[i] = caracteres[num + 3];
                        }
                    }
                }
                return new string(msgCifrada);
            }
            throw new ArgumentOutOfRangeException();
        }

        public string Decrypt(string cryptedMessage)
        {
            if (cryptedMessage == string.Empty)
            {
                return string.Empty;
            }

            if (cryptedMessage == null)
            {
                throw new ArgumentNullException();
            }

            char[] msgDecifrada = cryptedMessage.ToLower().ToCharArray();

            if (rgx.IsMatch(cryptedMessage.ToLower()))
            {
                for (int i = 0; i < msgDecifrada.Length; i++)
                {
                    int num = Array.IndexOf(caracteres, msgDecifrada[i]);

                    if (num >= 0)
                    {
                        if ((num - 3) < 0)
                        {
                            msgDecifrada[i] = caracteres[num - 3 + 26];
                        }

                        else
                        {
                            msgDecifrada[i] = caracteres[num - 3];
                        }
                    }
                }
                return new string(msgDecifrada);
            }
            throw new ArgumentOutOfRangeException();
        }
    }
}